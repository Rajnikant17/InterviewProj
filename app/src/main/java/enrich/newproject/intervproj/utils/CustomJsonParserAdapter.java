package enrich.newproject.intervproj.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import enrich.newproject.intervproj.model.Dataum;
import enrich.newproject.intervproj.model.ModelData;

public class CustomJsonParserAdapter extends TypeAdapter<ModelData> {
    int a=0;
    private Gson gson = new Gson();
    @Override
    public void write(JsonWriter out, ModelData value) throws IOException {

    }

    @Override
    public ModelData read(JsonReader reader) throws IOException {
        ModelData modelData=new ModelData();
        String fieldname = null;
        reader.setLenient(true);
        reader.beginObject();
        while (reader.hasNext()) {
            JsonToken token = reader.peek();
             if (token.equals(JsonToken.NAME)) {
                    fieldname = reader.nextName();
                }

                if ("data".equals(fieldname)) {
                    modelData.setData(readJsonStream(reader));

                }
            }
        reader.endObject();
        return modelData;
    }

    public List<Dataum> readJsonStream(JsonReader reader) throws IOException {
        try {
            return readDataumArray(reader);
        } finally {
            reader.close();
        }
    }

    public List<Dataum> readDataumArray(JsonReader reader) throws IOException {
        List<Dataum> dataums = new ArrayList<Dataum>();

        reader.beginArray();
        while (reader.hasNext()) {
            dataums.add(readDataum(reader));
        }
        reader.endArray();
        return dataums;
    }

    public Dataum readDataum(JsonReader reader) throws IOException {
        String id=null;
        String text = null;
        Dataum dataum=new Dataum();

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                id = reader.nextString();
                dataum.setId(id);
            } else if (name.equals("text")) {
                text = reader.nextString();
                dataum.setText(text);
            }

            else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return dataum;
    }
}

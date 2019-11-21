package enrich.newproject.intervproj.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ModelData implements Serializable {

    @SerializedName("status")
    @Expose
    String status;
    @SerializedName("data")
    @Expose
    private List<Dataum> data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Dataum> getData() {
        return data;
    }

    public void setData(List<Dataum> data) {
        this.data = data;
    }
}


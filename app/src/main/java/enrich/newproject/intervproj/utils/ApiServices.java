package enrich.newproject.intervproj.utils;

import java.util.List;

import enrich.newproject.intervproj.model.ModelData;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("fjaqJ")
    Single<ModelData> fetchContentdata();
}


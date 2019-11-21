package enrich.newproject.intervproj.DI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import enrich.newproject.intervproj.utils.ApiServices;
import enrich.newproject.intervproj.utils.Constants;
import enrich.newproject.intervproj.utils.CustomJsonParser;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

@Module
public class ApiCallModule {

    @Provides
    @Singleton
    OkHttpClient getOkhttpClient()
    {
        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder  builder=new OkHttpClient.Builder();
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .readTimeout(400, TimeUnit.SECONDS)
                .writeTimeout(400, TimeUnit.SECONDS)
                .build();
        return  okHttpClient;
    }

    @Provides
    @Singleton
    Retrofit getRetrofit(OkHttpClient okHttpClient)
    {
        Gson gson=new GsonBuilder()
                .setLenient()
                .serializeNulls()
                .create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.BASEURL)
                .addConverterFactory(new CustomJsonParser(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    ApiServices getapiServiceClass(Retrofit retrofit)
    {
        ApiServices apiServiceClass =retrofit.create(ApiServices.class);
        return  apiServiceClass;
    }
}

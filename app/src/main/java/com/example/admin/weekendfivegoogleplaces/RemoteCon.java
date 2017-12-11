package com.example.admin.weekendfivegoogleplaces;

import com.example.admin.weekendfivegoogleplaces.mapdata.Result;
import com.example.admin.weekendfivegoogleplaces.mapdata.SearchPlaces;
import com.example.admin.weekendfivegoogleplaces.nearbyplaces.NearByPlaces;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by  Admin on 12/10/2017.
 */

public class RemoteCon {
    private static OkHttpClient httpClientConfig(HttpLoggingInterceptor interceptor){
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();



    }
    private static HttpLoggingInterceptor loggingInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return  httpLoggingInterceptor;
    }
    private static final String Base_Url ="https://maps.googleapis.com/maps/api/place/textsearch/";
    private static final String Base_Url_NP = "https://maps.googleapis.com/maps/api/place/nearbysearch/";
    private static Retrofit create(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Base_Url)
                .client(httpClientConfig(loggingInterceptor()))
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }

    public static Call<SearchPlaces> searchPlaces(String searchTerm, String key){
        Retrofit retrofit = create();
        RemoteServices remoteServices = retrofit.create(RemoteServices.class);
        return  remoteServices.resultCall(searchTerm, key);
    }

    private static Retrofit createNP(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Base_Url_NP).client(httpClientConfig(loggingInterceptor())).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }
    public static Call<NearByPlaces> getNearByPlaces(String currentLocation, String radius, String type, String keyword, String apiKey){
        Retrofit retrofit = createNP();
        RemoteServices remoteServices = retrofit.create(RemoteServices.class);
        return remoteServices.searchNBPlacesCall(currentLocation, radius, type, keyword, apiKey);


    }
}

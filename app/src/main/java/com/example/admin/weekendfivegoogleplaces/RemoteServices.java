package com.example.admin.weekendfivegoogleplaces;


import com.example.admin.weekendfivegoogleplaces.mapdata.SearchPlaces;
import com.example.admin.weekendfivegoogleplaces.nearbyplaces.NearByPlaces;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query;

/**
 * Created by  Admin on 12/10/2017.
 */
public interface RemoteServices {
    @GET("json?")
    Call<SearchPlaces> resultCall(@Query("query") String query, @Query("key") String key);

    @GET("json?")

    Call<NearByPlaces> searchNBPlacesCall(@Query("location") String locationLangLat, @Query("radius")String radius, @Query("type") String type,@Query("keyword") String keyword, @Query("key") String key);

}

package com.chandan.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    @GET("weather")
    Call<Model> getData(@Query("q") String city, @Query("appid") String API,@Query("units") String units);
}

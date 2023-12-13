package com.chandan.weather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static String base_url = "https://api.openweathermap.org/data/2.5/";

    public static Retrofit getRetrofitInstance(){
        if(retrofit == null){
           retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

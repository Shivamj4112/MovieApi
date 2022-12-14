package com.api.movieapi.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static String Base_url = "https://api.themoviedb.org/";
    public static String IMAGE_URL = "https://image.tmdb.org/t/p/w500";

    public static Retrofit retrofit;

    public static Retrofit getApiClient(){

        retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        return retrofit;

    }


}

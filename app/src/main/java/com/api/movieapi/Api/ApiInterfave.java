package com.api.movieapi.Api;

import com.api.movieapi.ModelClass.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterfave {

    @POST("/3/tv/popular")
    Call<Example>getApiInterface(@Query("api_key")String api_key);
}

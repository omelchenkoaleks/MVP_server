package com.omelchenkoaleks.flowers.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowerApi {
    @GET("flowers/public/flowers")
    Call<FlowerResponse> getAllFlowers();
}
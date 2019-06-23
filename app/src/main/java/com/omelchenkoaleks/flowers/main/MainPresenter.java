package com.omelchenkoaleks.flowers.main;

import androidx.annotation.NonNull;

import com.omelchenkoaleks.flowers.model.Apis;
import com.omelchenkoaleks.flowers.model.FlowerApi;
import com.omelchenkoaleks.flowers.model.FlowerResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.MainPresenter {
    private MainContract.MainView view;
    private FlowerApi flowerApi;

    public MainPresenter(MainContract.MainView view) {
        this.view = view;
        flowerApi = Apis.getFlowerApi();
    }

    @Override
    public void getAllFlowers() {
        flowerApi.getAllFlowers().enqueue(new Callback<FlowerResponse>() {
            @Override
            public void onResponse(@NonNull Call<FlowerResponse> call, @NonNull Response<FlowerResponse> response) {
                FlowerResponse flowerResponse = response.body();
                if (flowerResponse != null){
                    view.showAllFlowers(flowerResponse.getResults());
                }
            }
            @Override
            public void onFailure(@NonNull Call<FlowerResponse> call, @NonNull Throwable t) {
                view.showMessage(t.getMessage());
            }
        });
    }
}

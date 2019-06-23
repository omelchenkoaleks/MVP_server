package com.omelchenkoaleks.flowers.main;

import com.omelchenkoaleks.flowers.model.Flower;

import java.util.List;

public interface MainContract {
    interface MainView {
        void showMessage(String message);
        void showAllFlowers(List<Flower> flowers);
    }

    interface MainPresenter {
        void getAllFlowers();
    }
}

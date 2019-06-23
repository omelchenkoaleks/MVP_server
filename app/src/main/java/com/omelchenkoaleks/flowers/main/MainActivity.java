package com.omelchenkoaleks.flowers.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.omelchenkoaleks.flowers.R;
import com.omelchenkoaleks.flowers.model.Flower;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    RecyclerView recyclerView;
    FlowerAdapter flowerAdapter;
    MainContract.MainPresenter presenter;
    ArrayList<Flower> flowerArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv_flowers);

        flowerAdapter = new FlowerAdapter(this,flowerArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(flowerAdapter);

        presenter = new MainPresenter(this);
        presenter.getAllFlowers();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAllFlowers(List<Flower> flowers) {
        flowerAdapter.setFlowers(flowers);
    }

}

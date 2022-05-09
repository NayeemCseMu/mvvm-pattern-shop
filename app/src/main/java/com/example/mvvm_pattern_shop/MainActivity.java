package com.example.mvvm_pattern_shop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.mvvm_pattern_shop.Service.Model.Product;
import com.example.mvvm_pattern_shop.Service.Model.ProductModel;
import com.example.mvvm_pattern_shop.View.Adapter.HomeProductAdapter;
import com.example.mvvm_pattern_shop.ViewModel.ProductViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ProductViewModel viewModel;
    private HomeProductAdapter adapter;
    private List<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvId);
        adapter = new HomeProductAdapter(MainActivity.this,products);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);



        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        viewModel.getProductList().observe(this, items -> {
            products.addAll(items);

            adapter.notifyDataSetChanged();


        });
    }
}
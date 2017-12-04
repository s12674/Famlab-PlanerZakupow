package com.famlab.mateusz.planer.ui.products;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.famlab.mateusz.planer.R;
import com.famlab.mateusz.planer.databinding.ActivityProductsBinding;
import com.famlab.mateusz.planer.ds.ApiDataSource;
import com.famlab.mateusz.planer.ds.models.Products;


/**
 * Created by Mateusz on 04.12.2017.
 */

public class ProductsActivity extends AppCompatActivity implements ProductsContract.View{

    private ActivityProductsBinding binding;
    private ProductsContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_products);
        presenter = new ProductsPresenter(this, new ApiDataSource());
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        int id = bundle.getInt("id");
        presenter.getProducts(id);
    }

    public void showProducts(Products products){
        ProductsAdapter adapter = new ProductsAdapter(products.products);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        binding.list.setLayoutManager(layoutManager);
        binding.list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}

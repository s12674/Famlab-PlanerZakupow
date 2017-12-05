package com.famlab.mateusz.planer.ui.products;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.famlab.mateusz.planer.R;
import com.famlab.mateusz.planer.databinding.ActivityProductsBinding;
import com.famlab.mateusz.planer.ds.database.ProductDAO;
import com.famlab.mateusz.planer.ds.models.Product;
import com.famlab.mateusz.planer.ds.models.Products;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FavActivity extends AppCompatActivity implements ProductsContract.View{

    private ActivityProductsBinding binding;
    private ProductsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_products);
        ProductDAO productDAO = new ProductDAO(this.getApplicationContext());
        Products products = new Products();
        System.out.println(productDAO.getAll().size() +  "SIZE");
        List<Product> productsArray = productDAO.getAll();
        if(productsArray.size()>0) {
            System.out.println(productsArray.get(0).thumbnail);
            products.products.add(productsArray.get(0));
            showFav(products);
        }
    }

    public void showFav(Products products){
        ProductsAdapter adapter = new ProductsAdapter(products.products);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        binding.list.setLayoutManager(layoutManager);
        binding.list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void showProducts(Products products){
        ProductsAdapter adapter = new ProductsAdapter(products.products);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        binding.list.setLayoutManager(layoutManager);
        binding.list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}

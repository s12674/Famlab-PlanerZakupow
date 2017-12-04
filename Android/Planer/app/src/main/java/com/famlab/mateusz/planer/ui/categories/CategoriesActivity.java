package com.famlab.mateusz.planer.ui.categories;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.famlab.mateusz.planer.R;
import com.famlab.mateusz.planer.databinding.ActivityCategoriesBinding;
import com.famlab.mateusz.planer.databinding.ActivityProductsBinding;
import com.famlab.mateusz.planer.ds.ApiDataSource;
import com.famlab.mateusz.planer.ds.models.Categories;
import com.famlab.mateusz.planer.ds.models.Products;
import com.famlab.mateusz.planer.ui.products.ProductsAdapter;
import com.famlab.mateusz.planer.ui.products.ProductsContract;
import com.famlab.mateusz.planer.ui.products.ProductsPresenter;

public class CategoriesActivity extends AppCompatActivity implements CategoriesContract.View{

    private ActivityCategoriesBinding binding;
    private CategoriesContract.Presenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_categories);
        presenter = new CategoriesPresenter(this, new ApiDataSource());
        presenter.getCategories();
    }

    public void showCategories(Categories categories){
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(categories.categories);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        binding.list.setLayoutManager(layoutManager);
        binding.list.setAdapter(categoriesAdapter);
        categoriesAdapter.notifyDataSetChanged();
    }

}
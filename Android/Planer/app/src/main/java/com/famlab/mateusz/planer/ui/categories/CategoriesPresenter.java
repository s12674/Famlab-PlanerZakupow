package com.famlab.mateusz.planer.ui.categories;

import com.famlab.mateusz.planer.ds.ApiDataSource;
import com.famlab.mateusz.planer.ui.products.ProductsContract;

/**
 * Created by Mateusz on 04.12.2017.
 */

public class CategoriesPresenter implements CategoriesContract.Presenter{

    private ApiDataSource apiDataSource;
    private CategoriesContract.View view;

    CategoriesPresenter(CategoriesContract.View view, ApiDataSource apiDataSource){
        this.view = view;
        this.apiDataSource = apiDataSource;
    }

    @Override
    public void getCategories(){
        apiDataSource.getCategories().subscribe(categoriesResponse -> {

            if(categoriesResponse.isSuccessful()){
                view.showCategories(categoriesResponse.body());
            } else{
                // błąd
            }
        });
    }
}

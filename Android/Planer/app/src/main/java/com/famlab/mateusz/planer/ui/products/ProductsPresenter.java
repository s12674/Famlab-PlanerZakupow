package com.famlab.mateusz.planer.ui.products;

import com.famlab.mateusz.planer.ds.ApiDataSource;

/**
 * Created by Mateusz on 04.12.2017.
 */

public class ProductsPresenter implements ProductsContract.Presenter{

    private ApiDataSource apiDataSource;
    private ProductsContract.View view;

    ProductsPresenter(ProductsContract.View view, ApiDataSource apiDataSource){
        this.view = view;
        this.apiDataSource = apiDataSource;
    }

    @Override
    public void getProducts(){
        apiDataSource.getProducts().subscribe(productsResponse -> {

            if(productsResponse.isSuccessful()){
                view.showProducts(productsResponse.body());
            } else{
                // błąd
            }
        });
    }
}
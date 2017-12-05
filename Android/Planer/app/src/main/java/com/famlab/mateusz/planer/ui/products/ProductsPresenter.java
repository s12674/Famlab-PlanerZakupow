package com.famlab.mateusz.planer.ui.products;

import com.famlab.mateusz.planer.ds.ApiDataSource;

/**
 * Created by Mateusz on 04.12.2017.
 */

public class ProductsPresenter implements ProductsContract.Presenter {

    private ApiDataSource apiDataSource;
    private ProductsContract.View view;

    ProductsPresenter(ProductsContract.View view, ApiDataSource apiDataSource) {
        this.view = view;
        this.apiDataSource = apiDataSource;
    }

    @Override
    public void getProducts() {
        apiDataSource.getProducts().subscribe(productsResponse -> {

            if (productsResponse.isSuccessful()) {
                view.showProducts(productsResponse.body());
            } else {
                // błąd
            }
        });
    }

    @Override
    public void getProducts(int id) {
        System.out.println(id + " ID");
        switch (id) {
            default:
                apiDataSource.getProducts().subscribe(productsResponse -> {

                    if (productsResponse.isSuccessful()) {
                        view.showProducts(productsResponse.body());
                    } else {
                        // błąd
                    }
                });
                break;
            case 1:
                apiDataSource.getOne().subscribe(productsResponse -> {

                    if (productsResponse.isSuccessful()) {
                        view.showProducts(productsResponse.body());
                    } else {
                        // błąd
                    }
                });
                break;
            case 2:
                apiDataSource.getTwo().subscribe(productsResponse -> {

                    if (productsResponse.isSuccessful()) {
                        view.showProducts(productsResponse.body());
                    } else {
                        // błąd
                    }
                });
                break;
            case 3:
                apiDataSource.getThree().subscribe(productsResponse -> {

                    if (productsResponse.isSuccessful()) {
                        view.showProducts(productsResponse.body());
                    } else {
                        // błąd
                    }
                });
                break;
        }

    }
}
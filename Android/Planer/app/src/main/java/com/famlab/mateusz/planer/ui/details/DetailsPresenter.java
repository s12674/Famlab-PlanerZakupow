package com.famlab.mateusz.planer.ui.details;

import com.famlab.mateusz.planer.ds.ApiDataSource;
import com.famlab.mateusz.planer.ds.models.Product;

/**
 * Created by Mateusz on 04.12.2017.
 */

public class DetailsPresenter implements DetailsContract.Presenter {

    private ApiDataSource apiDataSource;
    private DetailsContract.View view;

    DetailsPresenter(DetailsContract.View view, ApiDataSource apiDataSource) {
        this.view = view;
        this.apiDataSource = apiDataSource;
    }

    @Override
    public void getProduct(Product product){
        view.showProduct(product);
    }
}
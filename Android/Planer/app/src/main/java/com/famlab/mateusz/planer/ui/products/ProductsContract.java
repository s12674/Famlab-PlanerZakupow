package com.famlab.mateusz.planer.ui.products;

import com.famlab.mateusz.planer.ds.models.Products;

/**
 * Created by Mateusz on 04.12.2017.
 */

public interface ProductsContract {
    interface Presenter{
        void getProducts();
    }

    interface View{
        void showProducts(Products products);
    }
}

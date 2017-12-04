package com.famlab.mateusz.planer.ui.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.famlab.mateusz.planer.R;
import com.famlab.mateusz.planer.ds.models.Product;

/**
 * Created by Mateusz on 04.12.2017.
 */

public interface DetailsContract{

    interface View{
        void showProduct(Product product);
    }

    interface Presenter{
        void getProduct(Product product);
    }
}
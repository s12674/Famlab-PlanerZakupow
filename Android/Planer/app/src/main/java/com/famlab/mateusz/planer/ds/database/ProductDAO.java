package com.famlab.mateusz.planer.ds.database;

import android.content.Context;
import android.support.annotation.NonNull;

import com.famlab.mateusz.planer.ds.models.Product;

import java.util.List;

/**
 * Created by Mateusz on 05.12.2017.
 */

public class ProductDAO {
    private DBHelper helper;

    public ProductDAO(@NonNull Context context) {
        helper = new DBHelper(context);
    }

    public List<Product> getAll() {
        return helper.getAll(Product.class);
    }

    public void add(@NonNull Product product) {
        helper.create(Product.class, product);
    }

    public void update(@NonNull Product product) {
        helper.update(Product.class, product);
    }
}

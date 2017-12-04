package com.famlab.mateusz.planer.ui.products;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.famlab.mateusz.planer.databinding.ItemProductBinding;
import com.famlab.mateusz.planer.ds.models.Product;

/**
 * Created by Mateusz on 04.12.2017.
 */

public class ProductViewHolder extends RecyclerView.ViewHolder {

    private ItemProductBinding binding;

    ProductViewHolder(View rowView) {
        super(rowView);
        binding = DataBindingUtil.bind(rowView);
    }

    public void setProduct(Product product){
        binding.setProduct(product);
    }

}

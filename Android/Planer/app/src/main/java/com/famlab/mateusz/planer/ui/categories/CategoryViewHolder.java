package com.famlab.mateusz.planer.ui.categories;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.famlab.mateusz.planer.databinding.ItemCategoryBinding;
import com.famlab.mateusz.planer.ds.models.Category;

/**
 * Created by Mateusz on 04.12.2017.
 */

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private ItemCategoryBinding binding;

    CategoryViewHolder(View rowView) {
        super(rowView);
        binding = DataBindingUtil.bind(rowView);
    }

    public void setCategory(Category category) {
        binding.setCategory(category);
    }
}


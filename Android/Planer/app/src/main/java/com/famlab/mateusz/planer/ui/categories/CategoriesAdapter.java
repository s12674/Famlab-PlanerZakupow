package com.famlab.mateusz.planer.ui.categories;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.famlab.mateusz.planer.R;
import com.famlab.mateusz.planer.ds.models.Category;
import com.famlab.mateusz.planer.ui.products.ProductsActivity;

import java.util.ArrayList;

/**
 * Created by Mateusz on 04.12.2017.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<CategoryViewHolder> implements Filterable {

    public ArrayList<Category> categories;
    public ArrayList<Category> filteredCategories;
    private CategoryFilter filter;


    public CategoriesAdapter(ArrayList<Category> data) {
        this.categories = data;
        this.filteredCategories = new ArrayList<>();
        this.filteredCategories.addAll(this.categories);
    }

    // metoda zwracająca ilość elementów listy
    @Override
    public int getItemCount() {
        return (null != filteredCategories ? filteredCategories.size() : 0);
    }

    // metoda tworząca nowy widok elementu listy (ProductViewHolder)
    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    // funkcja odpowiadająca za łączenie danych i elementów na liście, wykonywana jest dla kazdego elementu listy
    @Override
    public void onBindViewHolder(final CategoryViewHolder holder, final int position) {
        // pobierz produkt
        Category category = filteredCategories.get(position);

        // ustaw produkt w widoku za pomocą bindingu
        holder.setCategory(category);

        // ustaw akcje po kliknieciu
        holder.itemView.setOnClickListener(view->{
            Intent intent = new Intent(holder.itemView.getContext(), ProductsActivity.class);
            intent.putExtra("id", category.id);
            view.getContext().startActivity(intent);

        });
    }

    // Dodanie filtra
    @Override
    public Filter getFilter() {
        if (filter == null)
            filter = new CategoryFilter(this, categories);
        return filter;
    }

}
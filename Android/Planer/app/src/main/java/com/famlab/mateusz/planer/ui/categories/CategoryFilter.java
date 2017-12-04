package com.famlab.mateusz.planer.ui.categories;

import android.widget.Filter;

import com.famlab.mateusz.planer.ds.models.Category;
import com.famlab.mateusz.planer.ui.products.ProductsAdapter;

import java.util.ArrayList;

/**
 * Created by Mateusz on 04.12.2017.
 */

public class CategoryFilter extends Filter {

    private final CategoriesAdapter adapter;
    private final ArrayList<Category> originalList;
    private final ArrayList<Category> filteredList;

    // filtrowanie produktów po nazwie
    CategoryFilter(CategoriesAdapter adapter, ArrayList<Category> originalList) {
        super();
        this.adapter = adapter;
        this.originalList = new ArrayList<>(originalList);
        this.filteredList = new ArrayList<>();
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        // wyczyść listę
        filteredList.clear();

        // nowa instacja rezultatów filtracji
        final FilterResults results = new FilterResults();

        // jeśli brak znaków - nie filtruj
        if (constraint.length() == 0) {
            filteredList.addAll(originalList);
        } else {
            final String filterPattern = constraint.toString().toLowerCase();

            for (final Category category : originalList) {
                if (category.name.toLowerCase().contains(filterPattern)) {
                    filteredList.add(category);
                }
            }
        }
        results.values = filteredList;
        results.count = filteredList.size();
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.filteredCategories.clear();
        adapter.filteredCategories.addAll((ArrayList<Category>) results.values);
        adapter.notifyDataSetChanged();
    }
}
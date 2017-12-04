package com.famlab.mateusz.planer.ui.products;

import android.widget.Filter;

import com.famlab.mateusz.planer.ds.models.Product;

import java.util.ArrayList;

/**
 * Created by Mateusz on 04.12.2017.
 */

public class ProductFilter extends Filter {

    private final ProductsAdapter adapter;
    private final ArrayList<Product> originalList;
    private final ArrayList<Product> filteredList;

    // filtrowanie produktów po nazwie
    ProductFilter(ProductsAdapter adapter, ArrayList<Product> originalList) {
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

            for (final Product product : originalList) {
                if (product.name.toLowerCase().contains(filterPattern)) {
                    filteredList.add(product);
                }
            }
        }
        results.values = filteredList;
        results.count = filteredList.size();
        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {
        adapter.filteredProducts.clear();
        adapter.filteredProducts.addAll((ArrayList<Product>) results.values);
        adapter.notifyDataSetChanged();
    }
}

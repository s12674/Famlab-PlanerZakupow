package com.famlab.mateusz.planer.ui.products;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.famlab.mateusz.planer.R;
import com.famlab.mateusz.planer.ds.models.Product;
import com.famlab.mateusz.planer.ui.details.DetailsActivity;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Mateusz on 04.12.2017.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> implements Filterable {

    public ArrayList<Product> products;
    public ArrayList<Product> filteredProducts;
    private ProductFilter filter;


    public ProductsAdapter(ArrayList<Product> data) {
        this.products = data;
        this.filteredProducts = new ArrayList<>();
        this.filteredProducts.addAll(this.products);
    }

    // metoda zwracająca ilość elementów listy
    @Override
    public int getItemCount() {
        return (null != filteredProducts ? filteredProducts.size() : 0);
    }

    // metoda tworząca nowy widok elementu listy (ProductViewHolder)
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    // funkcja odpowiadająca za łączenie danych i elementów na liście, wykonywana jest dla kazdego elementu listy
    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {
        // pobierz produkt
        Product product = filteredProducts.get(position);

        // ustaw produkt w widoku za pomocą bindingu
        holder.setProduct(product);

//         ustaw akcje po kliknieciu
        holder.itemView.setOnClickListener(view->{
            Intent intent = new Intent(holder.itemView.getContext(), DetailsActivity.class);
            intent.putExtra("product", (Serializable) product);
            view.getContext().startActivity(intent);

        });
    }

    // Dodanie filtra
    @Override
    public Filter getFilter() {
        if( filter == null)
            filter = new ProductFilter(this, products);
        return filter;
    }

}
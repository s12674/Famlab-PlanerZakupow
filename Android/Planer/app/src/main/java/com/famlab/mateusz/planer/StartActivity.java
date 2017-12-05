package com.famlab.mateusz.planer;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.famlab.mateusz.planer.ds.models.Categories;
import com.famlab.mateusz.planer.ui.categories.CategoriesActivity;
import com.famlab.mateusz.planer.ui.details.DetailsActivity;
import com.famlab.mateusz.planer.ui.products.FavActivity;

import java.io.Serializable;

public class StartActivity extends AppCompatActivity {

    private StartActivity binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Button b = (Button) findViewById(R.id.fav);
        b.setOnClickListener(view->{
            Intent intent = new Intent(getApplicationContext(), FavActivity.class);
            view.getContext().startActivity(intent);
        });

        Button a = (Button) findViewById(R.id.cat);
        a.setOnClickListener(view->{
            Intent intent = new Intent(getApplicationContext(), CategoriesActivity.class);
            view.getContext().startActivity(intent);
        });
    }
}

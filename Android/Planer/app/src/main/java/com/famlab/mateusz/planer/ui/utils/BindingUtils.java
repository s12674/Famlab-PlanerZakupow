package com.famlab.mateusz.planer.ui.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Mateusz on 04.12.2017.
 */

public class BindingUtils {

    @BindingAdapter(value = {"url"})
    public static void loadImage(ImageView imageView, String url) {
        if (url != null && !url.isEmpty()) {
            Picasso.with(imageView.getContext())
                    .load(url)
                    .into(imageView);
        }
    }


}

package com.pavelkovachev.sportsinfo.bindings;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageViewBindings {

    @BindingAdapter("path")
    public static void loadImage(ImageView imageView, String url) {
        Picasso.get().load(url).resize(480, 200).into(imageView);
    }
}
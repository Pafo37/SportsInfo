package com.pavelkovachev.sportsinfo.bindings;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.pavelkovachev.sportsinfo.Constants;
import com.squareup.picasso.Picasso;

public class ImageViewBindings {

    @BindingAdapter("path")
    public static void loadImage(ImageView imageView, String url) {
        Picasso.get().load(url).resize(Constants.IMAGE_HEIGHT, Constants.IMAGE_WIDTH).into(imageView);
    }
}
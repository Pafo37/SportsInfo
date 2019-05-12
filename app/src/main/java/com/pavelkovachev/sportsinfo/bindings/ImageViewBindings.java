package com.pavelkovachev.sportsinfo.bindings;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.pavelkovachev.sportsinfo.Constants;
import com.pavelkovachev.sportsinfo.R;
import com.squareup.picasso.Picasso;

public class ImageViewBindings {

    @BindingAdapter("path_homescreen")
    public static void loadImageHomeScreen(ImageView imageView, String url) {
        Picasso.get().load(url).resize(Constants.IMAGE_HEIGHT, Constants.IMAGE_WIDTH).into(imageView);
    }

    @BindingAdapter("path")
    public static void loadImage(ImageView imageView, String url) {
        if (url.isEmpty()) {
            Picasso.get().load(R.drawable.img_not_available).into(imageView);
        } else {
            Picasso.get().load(url).into(imageView);
        }
    }
}
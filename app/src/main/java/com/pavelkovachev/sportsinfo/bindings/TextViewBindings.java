package com.pavelkovachev.sportsinfo.bindings;

import android.databinding.BindingAdapter;
import android.widget.TextView;

public class TextViewBindings {

    @BindingAdapter("shortDescription")
    public static void setTextLength(TextView textView, String text) {
        if (text.length() > 220) {
            textView.setText(text.substring(0, 220) + "...");
        } else {
            textView.setText(text);
        }
    }
}
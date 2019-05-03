package com.pavelkovachev.sportsinfo.bindings;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import com.pavelkovachev.sportsinfo.Constants;

public class TextViewBindings {

    @BindingAdapter("shortDescription")
    public static void setTextLength(TextView textView, String text) {
        if (text.length() > Constants.TEXT_LENGTH) {
            textView.setText(text.substring(0, Constants.TEXT_LENGTH) + "...");
        } else {
            textView.setText(text);
        }
    }
}
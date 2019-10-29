package com.pavelkovachev.sportsinfo.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pavelkovachev.sportsinfo.R;

public class LoadingView extends ConstraintLayout {

    private View view;
    private ProgressBar progressBar;
    private TextView textView;

    public LoadingView(Context context) {
        super(context);
        init(context);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        view = inflate(context, R.layout.loading_view, this);
        progressBar = view.findViewById(R.id.progress_bar);
        textView = view.findViewById(R.id.txt_loading_view);
    }

    public void setProgressBarVisibility(boolean isVisible) {
        progressBar.setVisibility(isVisible ? VISIBLE : GONE);
    }

    public void setTextViewVisibility(boolean isVisible) {
        textView.setVisibility(isVisible ? VISIBLE : GONE);
    }
}
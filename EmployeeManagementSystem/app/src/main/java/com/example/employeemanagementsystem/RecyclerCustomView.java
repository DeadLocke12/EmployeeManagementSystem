package com.example.employeemanagementsystem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerCustomView extends RecyclerView{

    private boolean verticleScrollingEnabled = true;

    public void enableVersticleScroll (boolean enabled) {
        verticleScrollingEnabled = enabled;
    }

    public boolean isVerticleScrollingEnabled() {
        return verticleScrollingEnabled;
    }

    @Override


    public int computeVerticalScrollRange() {

        if (isVerticleScrollingEnabled())
            return super.computeVerticalScrollRange();
        return 0;
    }

/* */
    @Override
    public boolean onInterceptTouchEvent(
            MotionEvent e) {

        if(isVerticleScrollingEnabled())
            return super.onInterceptTouchEvent(e);
        return false;

    }

    public RecyclerCustomView(@NonNull Context context) {
        super(context);
    }
    public RecyclerCustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public RecyclerCustomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}

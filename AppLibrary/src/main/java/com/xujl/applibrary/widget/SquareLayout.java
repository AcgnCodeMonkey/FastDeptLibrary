package com.xujl.applibrary.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by xujl on 2017/11/28.
 * 正方形布局
 */

public class SquareLayout extends LinearLayout {


    public SquareLayout (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SquareLayout (Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquareLayout (Context context) {
        super(context);
    }

    @Override
    protected void onMeasure (int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int measuredWidth = getMeasuredWidth();
        final int measuredHeight = getMeasuredHeight();
        final int max = Math.max(measuredHeight, measuredWidth);
        setMeasuredDimension(max, max);
    }


}

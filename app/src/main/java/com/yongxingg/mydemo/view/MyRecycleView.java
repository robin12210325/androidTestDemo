package com.yongxingg.mydemo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/**
 * Created by gaoyongxing on 2018-3-31.
 */
public class MyRecycleView extends RecyclerView {
    private int mTouchSlop;
    private float xDistance, yDistance, xLast, yLast;

    public MyRecycleView(Context context) {
        super(context);
        init();
    }

    public MyRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyRecycleView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        final ViewConfiguration configuration = ViewConfiguration.get(getContext());
        mTouchSlop = configuration.getScaledTouchSlop();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        ViewParent parent = this;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.d("hailong12"," ACTION_DOWN ");
                xDistance = yDistance = 0f;
                xLast = ev.getX();
                yLast = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float curX = ev.getX();
                final float curY = ev.getY();
                xDistance += Math.abs(curX - xLast);
                yDistance += Math.abs(curY - yLast);
                xLast = curX;
                yLast = curY;
                if (xDistance >= mTouchSlop && xDistance > yDistance) {
                    while (!((parent = parent.getParent()) instanceof ViewPager)) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                }
                break;
            case MotionEvent.ACTION_UP:
                while (!((parent = parent.getParent()) instanceof ViewPager)) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
                if (xDistance >= mTouchSlop && xDistance > yDistance) {
                }else{
//                    transInToDetail();
                }
                break;
        }

        return super.dispatchTouchEvent(ev);

    }
}

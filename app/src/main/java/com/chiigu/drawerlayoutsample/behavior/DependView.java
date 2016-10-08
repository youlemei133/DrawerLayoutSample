package com.chiigu.drawerlayoutsample.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Created by hudawei on 2016/10/8.
 */
public class DependView extends TextView {
    public DependView(Context context) {
        super(context);
    }

    public DependView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    float startX,startY;
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                startX=event.getX();
                startY=event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float x=event.getX();
                float y=event.getY();
                setPosition(x-startX,y-startY);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    public void setPosition(float x,float y){
        CoordinatorLayout.LayoutParams params= (CoordinatorLayout.LayoutParams) this.getLayoutParams();
        params.leftMargin+=(int) x;
        params.topMargin+=(int)y;
        this.setLayoutParams(params);
    }
}

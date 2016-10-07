package com.chiigu.drawerlayoutsample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class DrawerLayoutActivity extends Activity {

    private DrawerLayout drawerLayout;
    private FrameLayout fl_content;
    private RelativeLayout rl_navigation;
    private final static String TAG="DrawerLayout";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        fl_content=(FrameLayout)findViewById(R.id.fl_content);
        rl_navigation=(RelativeLayout)findViewById(R.id.rl_navigation);
        initDrawerLayout();
    }

    public void initDrawerLayout(){
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
//                Log.e(TAG,"onDrawerSlide:"+slideOffset);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Log.e(TAG,"onDrawerOpened");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Log.e(TAG,"onDrawerClosed");
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                Log.e(TAG,"onDrawerStateChanged:"+newState);
            }
        });
    }

}

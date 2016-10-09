package com.chiigu.drawerlayoutsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

/**
 * Created by hudawei on 2016/10/8.
 */
public class CollapsingToolbarLayoutActivity extends AppCompatActivity {
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing);
        appBarLayout=(AppBarLayout)findViewById(R.id.appBarLayout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                //可以根据verticalOffset，以及appBarLayout.getTotalScrollRange()，来确定收缩比例，从而实现一些效果
                Log.e("OnOffsetChangedListener","verticalOffset:"+verticalOffset+"\t"+appBarLayout.getTotalScrollRange());
            }
        });

        Toolbar toolBar=(Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        ActionBar bar=getSupportActionBar();
        bar.setDisplayShowTitleEnabled(true);
    }
}

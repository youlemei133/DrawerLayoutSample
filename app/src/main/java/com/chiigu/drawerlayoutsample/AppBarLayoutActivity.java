package com.chiigu.drawerlayoutsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by hudawei on 2016/10/8.
 *
 */
public class AppBarLayoutActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbarlayout);

        appBarLayout=(AppBarLayout)findViewById(R.id.appBarLayout);
        toolBar=(Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        toolBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AppBarLayout.LayoutParams params= (AppBarLayout.LayoutParams) toolBar.getLayoutParams();
                params.height=dp2px(55);
                toolBar.setMinimumHeight(dp2px(0));
                switch (item.getItemId()){
                    case R.id.scroll:
                        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
                        break;
                    case R.id.enterAlways:
                        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS|AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
                        break;
                    case R.id.exitUntilCollapsed:
                        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED|AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
                        params.height=dp2px(200);
                        toolBar.setMinimumHeight(dp2px(55));
                        break;
                    case R.id.enterAlwaysCollapsed:
                        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED|AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS|AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
                        params.height=dp2px(200);
                        toolBar.setMinimumHeight(dp2px(55));
                        break;
                }
                toolBar.setLayoutParams(params);
                return true;
            }
        });

        ActionBar bar=getSupportActionBar();
        bar.setDisplayShowTitleEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_appbarlayout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public int dp2px(float dpValue) {
        float density = getResources().getDisplayMetrics().density;
        return (int) (dpValue * density + 0.5f);
    }
}

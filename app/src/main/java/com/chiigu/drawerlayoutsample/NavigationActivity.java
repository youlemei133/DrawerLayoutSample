package com.chiigu.drawerlayoutsample;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

/**
 * Created by hudawei on 2016/10/7.
 *
 */
public class NavigationActivity extends Activity {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerLayout);
        navigationView=(NavigationView)findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Snackbar.make(navigationView,item.getItemId()+"  "+item.getTitle(),Snackbar.LENGTH_SHORT).show();
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
}

package com.chiigu.drawerlayoutsample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt_drawerLayout:
                startActivity(new Intent(this,DrawerLayoutActivity.class));
                break;
            case R.id.bt_navigationView:
                startActivity(new Intent(this,NavigationActivity.class));
                break;
            case R.id.bt_toolBar:
                startActivity(new Intent(this,ToolBarActivity.class));
                break;
            case R.id.bt_coordinaryLayout:
                startActivity(new Intent(this,CoordinaryLayoutActivity.class));
                break;
            case R.id.bt_appBarLayout:
                startActivity(new Intent(this,AppBarLayoutActivity.class));
                break;
            case R.id.bt_collapsingToolbarLayout:
                startActivity(new Intent(this,CollapsingToolbarLayoutActivity.class));
                break;
        }
    }

}

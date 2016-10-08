package com.chiigu.drawerlayoutsample;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by hudawei on 2016/10/7.
 */
public class ToolBarActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);



        toolbar=(Toolbar)findViewById(R.id.toolBar);
        toolbar.setTitle("我的行程");//设置title
//        toolbar.setSubtitle("SubTitle");//设置SubTitle
//        toolbar.setLogo(R.mipmap.ic_launcher);//设置Logo

        setSupportActionBar(toolbar);//设置ActionBar为我们的ToolBar
        toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);//设置Navigation图标

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {//设置Action的点击事件
                String msg="";
                switch (item.getItemId()){
                    case R.id.item_search:
                        msg="搜索";
                        break;
                    case R.id.item_delete:
                        msg="删除";
                        break;
                    case R.id.item_info:
                        msg="信息";
                        break;
                    case R.id.item_settings:
                        msg="设置";
                        break;
                }
                Snackbar.make(toolbar,msg,Snackbar.LENGTH_SHORT).show();
                return true;
            }
        });

        //获取ActionBar
        ActionBar bar=getSupportActionBar();
        //允许返回指定的父Activity
        bar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tb,menu);//将menu_tb添加到我们ToolBar的Action中
        return true;
    }
}

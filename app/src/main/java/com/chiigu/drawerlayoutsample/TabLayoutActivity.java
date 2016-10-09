package com.chiigu.drawerlayoutsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.chiigu.drawerlayoutsample.tablayout.TabLayoutFragment;
import com.chiigu.drawerlayoutsample.tablayout.TabLayoutFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hudawei on 2016/10/9.
 *
 */
public class TabLayoutActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private final String[] titles={"推荐","订阅","电视剧","电影","综艺","娱乐"};
    private FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        fab=(FloatingActionButton)findViewById(R.id.floatingActionButton);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);

        addTabs();
        tabLayout.setupWithViewPager(viewPager);//与ViewPager关联，注意此时tab的title有viewpager的适配器Adapter中的方法getPageTitle设置title

//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//            }
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//            }
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            }
//        });
        setToolBar();
    }

    private void addTabs() {
        List<Fragment> fragments=new ArrayList<>();
        for(String title:titles){
//            tabLayout.addTab(tabLayout.newTab().setText(title));//与ViewPager结合使用的时候不需要使用该方法
            fragments.add(TabLayoutFragment.newInstance(title));
        }
        viewPager.setAdapter(new TabLayoutFragmentAdapter(getSupportFragmentManager(),fragments,titles));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Snackbar.make(viewPager,titles[position],Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void setToolBar(){
        Toolbar toolBar=(Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        ActionBar bar=getSupportActionBar();
        bar.setDisplayShowTitleEnabled(true);
    }
}

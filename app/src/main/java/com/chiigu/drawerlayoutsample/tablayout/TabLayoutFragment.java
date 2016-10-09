package com.chiigu.drawerlayoutsample.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chiigu.drawerlayoutsample.R;

/**
 * Created by hudawei on 2016/10/9.
 *
 */
public class TabLayoutFragment extends Fragment {

    public static TabLayoutFragment newInstance(String title) {
        Bundle args = new Bundle();
        args.putString("tittle",title);
        TabLayoutFragment fragment = new TabLayoutFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tablayout,container,false);
        LinearLayout frag_lv= (LinearLayout) view.findViewById(R.id.frag_lv);

        for(int i=0;i<10;i++){
            View itemView=inflater.inflate(R.layout.item_scroll,null);
            TextView textView= (TextView) itemView.findViewById(R.id.item_scroll_tv);
            textView.setText(getArguments().getString("tittle")+" "+(i+1));
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(-1,-2);
            params.topMargin=50;
            params.bottomMargin=50;
            params.leftMargin=50;
            params.rightMargin=50;
            itemView.setLayoutParams(params);
            frag_lv.addView(itemView);
        }
        return view;
    }
}

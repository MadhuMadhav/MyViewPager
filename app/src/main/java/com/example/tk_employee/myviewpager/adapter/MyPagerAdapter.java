package com.example.tk_employee.myviewpager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tk_employee.myviewpager.activity.MainActivity;
import com.example.tk_employee.myviewpager.activity.SelectedPageActivity;

public class MyPagerAdapter extends PagerAdapter {
    private Context context;
    private int [] layouts;
    private LayoutInflater layoutInflater;
    public MyPagerAdapter(Context context, int[] layouts) {
        this.context=context;
        this.layouts=layouts;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        int virtualPosition=position%layouts.length;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(layouts[virtualPosition], container, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).startNewActivity(position%layouts.length,SelectedPageActivity.class);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
       // return layouts.length;
        return Integer.MAX_VALUE;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}

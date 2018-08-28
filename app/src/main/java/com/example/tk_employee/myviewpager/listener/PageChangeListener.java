package com.example.tk_employee.myviewpager.listener;

import android.content.Context;
import android.support.v4.view.ViewPager;

import com.example.tk_employee.myviewpager.activity.MainActivity;


public class PageChangeListener implements ViewPager.OnPageChangeListener {
    private Context context;
    private int[] layouts;
    public PageChangeListener(Context context, int[] layouts) {
        this.context=context;
        this.layouts=layouts;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {

        ((MainActivity)context).addBottomDots(position%layouts.length,position-1);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}

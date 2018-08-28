package com.example.tk_employee.myviewpager.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tk_employee.myviewpager.adapter.MyPagerAdapter;
import com.example.tk_employee.myviewpager.listener.PageChangeListener;
import com.example.tk_employee.myviewpager.R;

import static com.example.tk_employee.myviewpager.commonvaribles.CommonVariables.DELAY;

public class MainActivity extends AppCompatActivity {

    private PageChangeListener pageChangeListener;
    private MyPagerAdapter myPagerAdapter;
    private Handler handler;
    private Runnable runnable;
    private LinearLayout dotsLayout;
    private ViewPager viewPager;
    private int [] layouts;
    private int position=0;
    private TextView [] dots;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layouts = new int[]{R.layout.slide1, R.layout.slide2, R.layout.slide3, R.layout.slide4
                , R.layout.slide5, R.layout.slide6, R.layout.slide7};

        handler=new Handler();
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        dotsLayout=(LinearLayout)findViewById(R.id.layoutDots);

        myPagerAdapter=new MyPagerAdapter(MainActivity.this,layouts);
        viewPager.setAdapter(myPagerAdapter);

        addBottomDots(0,(myPagerAdapter.getCount()/2)-1);

        viewPager.setPadding(100,0,100,0);
        //viewPager.setPageMargin(10);
        pageChangeListener=new PageChangeListener(this,layouts);
        viewPager.addOnPageChangeListener(pageChangeListener);

    }
    public void addBottomDots(int currentPage,int page) {
        dots=new TextView[layouts.length];

        position=page;
        dotsLayout.removeAllViews();

        for (int i=0;i<dots.length;i++)
        {
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getColor(R.color.dots_color_inactive));
            dotsLayout.addView(dots[i]);
        }
        if (dots.length>0)
            dots[currentPage].setTextColor(getColor(R.color.dots_color_active));
    }

    public void startNewActivity(int position, Class<? extends Activity> activity) {
        Intent intent=new Intent(MainActivity.this,activity);
        intent.putExtra("position",position+1);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //handler.postDelayed(runnable,DELAY);

        runOnUiThread( runnable=new Runnable() {
            @Override
            public void run() {
                position++;
                viewPager.setCurrentItem(position,true);
                handler.postDelayed(this,DELAY);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }
}




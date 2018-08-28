package com.example.tk_employee.myviewpager.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tk_employee.myviewpager.R;

public class SelectedPageActivity extends AppCompatActivity {
    private TextView tvSlide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_page);
        Intent intent=getIntent();

        int position=intent.getExtras().getInt("position");
        tvSlide=(TextView)findViewById(R.id.tvSlide);
        tvSlide.setText("Slide "+position);
    }
}

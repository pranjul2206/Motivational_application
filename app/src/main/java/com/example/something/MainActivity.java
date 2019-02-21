package com.example.something;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    private ViewPager pager;
    private LinearLayout linearLayout;
    private sliderAdapter slider;
    private TextView[] mdots;
    private Button back;
    private Button next;
    private int ncurrentpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager=findViewById(R.id.pager);
        linearLayout=findViewById(R.id.dot);
        back=findViewById(R.id.back);
        next=(Button)findViewById(R.id.next);
        slider=new sliderAdapter(this);
        pager.setAdapter(slider);
        addDotIndicator(0);
        pager.addOnPageChangeListener(viewListner);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(ncurrentpage==mdots.length-1)
                {
                    openActivity2();
                }
              pager.setCurrentItem(ncurrentpage+1);
            }
        });
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                pager.setCurrentItem(ncurrentpage-1);
            }
        });

    }

    private void openActivity2() {
        Intent intent=new Intent(this,second.class);
        startActivity(intent);
    }

    public void addDotIndicator(int position){
        mdots=new TextView[4];
        linearLayout.removeAllViews();
        for(int i=0;i<mdots.length;i++) {
            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226;"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.whiteTransparent));
            linearLayout.addView(mdots[i]);

        }
        if(mdots.length>0)
        {
          mdots[position].setTextColor(getResources().getColor(R.color.black));
        }
    }
    ViewPager.OnPageChangeListener viewListner=new ViewPager.OnPageChangeListener(){
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
        addDotIndicator(i);
        ncurrentpage=i;
        if(i==0)
        {
            next.setEnabled(true);
            back.setEnabled(false);
            back.setVisibility(View.INVISIBLE);
            next.setText("NEXT");
            back.setText("");
        }
        else if(i==mdots.length-1){
            next.setEnabled(true);
            back.setEnabled(true);
            back.setVisibility(View.VISIBLE);
            next.setText("FINISH");
            back.setText("BACK");
        }
        else{
            next.setEnabled(true);
            back.setEnabled(true);
            back.setVisibility(View.VISIBLE);
            next.setText("NEXT");
            back.setText("BACK");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}

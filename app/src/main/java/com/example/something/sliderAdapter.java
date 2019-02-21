package com.example.something;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class sliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public sliderAdapter(Context context)
    {
        this.context=context;
    }
    public int[] slide_images={
            R.drawable.wellness,
            R.drawable.dumble,
            R.drawable.pokemon_50fps,
            R.drawable.last,
    };
    public String[] slide_headings={
            "HEADING 1",
            "HEADING 2",
            "HEADING 3",
            "HEADING 4"

    };
    public String[] slide_discriptions={
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,"

    };
    public String[] slide_color={
       "#4DA87C",
            "#A2DAB7",
            "#4AB86F",
            "#FFFFFF"
    };
    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(RelativeLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater= (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide,container,false);
        RelativeLayout r=view.findViewById(R.id.relativebackground);
        GifImageView gif=(GifImageView)view.findViewById(R.id.gifView);
        TextView heading=(TextView)view.findViewById(R.id.textView);
        TextView disc=(TextView)view.findViewById(R.id.textView2);
        gif.setImageResource(slide_images[position]);
        heading.setText(slide_headings[position]);
        disc.setText(slide_discriptions[position]);
        r.setBackgroundColor(Color.parseColor(slide_color[position]));
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}

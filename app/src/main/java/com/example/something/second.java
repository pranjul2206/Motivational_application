package com.example.something;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import me.itangqi.waveloadingview.WaveLoadingView;
import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;


public class second extends AppCompatActivity {
    WaveLoadingView waveLoadingView;
    SeekBar seekBar;
    FlipperLayout flipper;
    TextView t;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //--------SLIDE IMAGE
        flipper=(FlipperLayout)findViewById(R.id.flipper);
        t=(TextView)findViewById(R.id.textView);
        setLayout();
        //--------SLIDE IMAGE
        //Bubbles code
        seekBar=(SeekBar)findViewById(R.id.seekbar);
        waveLoadingView=(WaveLoadingView)findViewById(R.id.waveLoadingView);
        waveLoadingView.setProgressValue(0);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                waveLoadingView.setProgressValue(progress);
                if(progress<50)
                {
                    waveLoadingView.setBottomTitle(String.format("%d%%",progress));
                    waveLoadingView.setCenterTitle("");
                    waveLoadingView.setTopTitle("");
                }
                if(progress<80)
                {
                    waveLoadingView.setBottomTitle("");
                    waveLoadingView.setCenterTitle(String.format("%d%%",progress));
                    waveLoadingView.setTopTitle("");
                }
                else{
                    waveLoadingView.setBottomTitle("");
                    waveLoadingView.setCenterTitle("");
                    waveLoadingView.setTopTitle(String.format("%d%%",progress));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
    }
    private void setLayout()
    {
        String url[]=new String[]{
                "https://cdn-images-1.medium.com/max/1600/1*6Ak3LPymYWuXKrhPpa1SAA.png",
                "https://bjsm.bmj.com/content/bjsports/early/2017/09/04/bjsports-2017-097625/F1.large.jpg",
                "https://i.ytimg.com/vi/SKYtrKQ0-Qs/maxresdefault.jpg"
        };
        for( i=0;i<3;i++)
        {
            FlipperView view =new FlipperView(getBaseContext());
            view.setImageUrl(url[i]);
            flipper.addFlipperView(view);
            view.setOnFlipperClickListener(new FlipperView.OnFlipperClickListener() {
                @Override
                public void onFlipperClick(FlipperView flipperView) {
                    t.setText("image" + i);
                }
            });
        }
    }
    }


package com.example.a171y039.mycountdowntimer100;

import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    TextView mTimerText;
    MyCountDownTimer  mTimer;
    FloatingActionButton mFab;

        public class MyCountDownTimer extends CountDownTimer {
            public boolean isRunning = false;

        public MyCountDownTimer(long millisInFuture,
                                long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntiFinished){
            long minute = millisUntiFinished / 1000 / 60;
            long second = millisUntiFinished / 1000 % 60;
            mTimerText.setText(String.format("%1d:%2$02d",minute,second));
        }

        @Override
        public void onFinish() {
            mTimerText.setText("0:00");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTimerText = (TextView) findViewById(R.id.timer_text);
        mTimerText.setText("3:00");
        mTimer = new MyCountDownTimer(30 * 60 * 1000,100);

        mFab = (FloatingActionButton) findViewById(R.id.play_stop);
        mFab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mTimer.isRunning){
                    mTimer.isRunning = false;
                    mTimer.cancel();
                    mFab.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                }else{
                    mTimer.isRunning = true;
                    mTimer.start();
                    mFab.setImageResource(R.drawable.ic_stop_black_24dp);
                }
            }
        });
    }
}

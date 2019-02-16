package com.example.mypc.Shee;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class SchemesActivity extends AppCompatActivity {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schemes);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);

    }
    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            SchemesActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem()==0){
                        viewPager.setCurrentItem(1);

                    }else if(viewPager.getCurrentItem()==1){
                        viewPager.setCurrentItem(2);
                    }else if(viewPager.getCurrentItem()==2){
                        viewPager.setCurrentItem(3);
                    }else {
                        viewPager.setCurrentItem(0);
                    }
                }
            });
        }

    }
    public void s1(View view){
        Intent bo=new Intent(this,SeniorCitizenActivity.class);
        startActivity(bo);
    }
    public void s2(View view){
        Intent bo=new Intent(this,PregnentLadiesActivity.class);
        startActivity(bo);
    }
    public void s3(View view){
        Intent bo=new Intent(this,DifferentlyAbledActivity.class);
        startActivity(bo);
    }
    public void s4(View view){
        Intent bo=new Intent(this,TransgenderActivity.class);
        startActivity(bo);
    }
    public void s5(View view){
        Intent bo=new Intent(this,WidowedActivity.class);
        startActivity(bo);
    }
    public void s6(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.newincept.com/all-state-government-schemes.html"));
        startActivity(browserIntent);
    }

}


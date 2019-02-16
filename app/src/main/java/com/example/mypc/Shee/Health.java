package com.example.mypc.Shee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Health extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);
    }
    public void f1(View view){
        Intent bo=new Intent(this,food1Activity.class);
        startActivity(bo);
    }
    public void f2(View view){
        Intent bo=new Intent(this,food2Activity.class);
        startActivity(bo);
    }
    public void f3(View view){
        Intent bo=new Intent(this,food3Activity.class);
        startActivity(bo);
    }
    public void f4(View view){
        Intent bo=new Intent(this,food4Activity.class);
        startActivity(bo);
    }
}

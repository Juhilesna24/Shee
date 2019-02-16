package com.example.mypc.Shee;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EnterpreneursActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterpreneurs);
    }
    public void t1(View view){
        Intent bo=new Intent(this,TrainingActivity.class);
        startActivity(bo);
    }
    public void t2(View view){
        Intent bo=new Intent(this,EntLoanActivity.class);
        startActivity(bo);
    }
}

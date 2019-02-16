package com.example.mypc.Shee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EntLoanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ent_loan);
    }
    public void e1(View view){
        Intent bo=new Intent(this,Ent1Activity.class);
        startActivity(bo);
    }
    public void e2(View view){
        Intent bo=new Intent(this,Ent2Activity.class);
        startActivity(bo);
    }
    public void e3(View view){
        Intent bo=new Intent(this,Ent3Activity.class);
        startActivity(bo);
    }
    public void e4(View view){
        Intent bo=new Intent(this,Ent4Activity.class);
        startActivity(bo);
    }
}

package com.example.mypc.Shee;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mypc.Shee.Helper.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
 private Button Login,Register;
    private EditText Email,Password;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Login=(Button) findViewById(R.id.Login);
        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                login();

            }
        });
        Register=(Button) findViewById(R.id.Register);
        Register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i=new Intent(LoginActivity.this,UserProfileActivity.class);
                startActivity(i);

            }
        });
        mAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        Email=(EditText) findViewById(R.id.editText);
        Password=(EditText)findViewById(R.id.editText2);
       // if(mAuth.getCurrentUser()!=null){
          //  Intent i=new Intent(getApplicationContext(),LoginActivity.class);
            //startActivity(i);
        //}
    }
    private void login(){
        String email=Email.getText().toString().trim();
        String password=Password.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this,"Enter your Email",Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            // password is empty
            Toast.makeText(this,"Enter your Password",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Logging in");
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                   progressDialog.dismiss();
                        if(task.isSuccessful()){
                            finish();
                            Intent i=new Intent(LoginActivity.this,HomeActivity.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Enter valid email and password",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

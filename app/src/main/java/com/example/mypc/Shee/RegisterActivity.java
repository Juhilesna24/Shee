package com.example.mypc.Shee;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{



    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextpassword;
    private TextView textViewsignin;
    private ProgressDialog progressDialog;
private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private static final int PICK_IMAGE=100;
    Uri imageUri;
FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference dbref=db.getReference("Shee");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth=FirebaseAuth.getInstance();
       // FirebaseDatabase.getInstance().setPersistenceEnabled(true);

progressDialog=new ProgressDialog(this);
        buttonRegister=(Button)findViewById(R.id.buttonRegister);
        editTextEmail=(EditText) findViewById(R.id.editTextEmail);
        editTextpassword=(EditText)findViewById(R.id.editTextPassword);
        textViewsignin=(TextView)findViewById(R.id.textviewSignin);

dbref.setValue("hello");
        //rg = (RadioGroup) findViewById(R.id.rgroup);
        //spinner
buttonRegister.setOnClickListener(this);
        textViewsignin.setOnClickListener(this);

    }
    private void registeruser(){
        String email=editTextEmail.getText().toString().trim();
        String password=editTextpassword.getText().toString().trim();

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
        //if validations are ok ,shows a progress bar


        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       //progressDialog.setMessage("Registering user");
                       ///progressDialog.show();
                       //user is successfully registered
                       if(mAuth.getCurrentUser()!=null){
                           Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                           startActivity(i);
                       }

                       Toast.makeText(RegisterActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                       return;
                   }
                        else{
                       //progressDialog.setMessage("Registering user");
                       //progressDialog.show();
                       Toast.makeText(RegisterActivity.this,"Please try again later",Toast.LENGTH_SHORT).show();
                       return;
                   }


                    }
                });

    }

    @Override
    public void onClick(View v) {
        if(v==buttonRegister){
            registeruser();
        }
        if(v==textViewsignin){
            //will open login activity
Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }
    }
}

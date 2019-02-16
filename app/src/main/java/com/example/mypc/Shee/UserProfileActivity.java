package com.example.mypc.Shee;

import android.app.Activity;
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

public class UserProfileActivity extends Activity implements View.OnClickListener{
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference dbref=db.getReference("Shee");

    RadioGroup rg;
    RadioButton rb;
    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextpassword,editTextConfirmPassword1,editTextMobile,editTextDate,editTextName;
    private TextView textViewsignin;
    private ProgressDialog progressDialog;

    private static final int PICK_IMAGE=100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        mAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        buttonRegister=(Button)findViewById(R.id.RegisterButton);
        editTextEmail=(EditText) findViewById(R.id.Email1);
        editTextpassword=(EditText)findViewById(R.id.Password1);
        textViewsignin=(TextView)findViewById(R.id.textviewSignin);


        rg = (RadioGroup) findViewById(R.id.rgroup);
        //spinner
        /*Spinner Spinner = (Spinner) findViewById(R.id.State1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.STATES, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner.setAdapter(adapter);*/

        buttonRegister.setOnClickListener(this);
        textViewsignin.setOnClickListener(this);

    }

    public void rbclick(View v)
    {
        int radiobuttonid= rg.getCheckedRadioButtonId();
        rb= (RadioButton) findViewById(radiobuttonid);

        Toast.makeText(getBaseContext(),rb.getText(),Toast.LENGTH_LONG).show();
    }
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        String sSelected=parent.getItemAtPosition(position).toString();
        Toast.makeText(this,sSelected, Toast.LENGTH_SHORT).show();
    }
    public void onNothingSelected(AdapterView<?> parent){}

    public void onClick(View v) {
        if(v==buttonRegister){
            registeruser();
            datastore();
        }
        if(v==textViewsignin){
            //will open login activity
            Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        }
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

                            Toast.makeText(UserProfileActivity.this,"Registered Successfully",Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else{
                            //progressDialog.setMessage("Registering user");
                            //progressDialog.show();
                            Toast.makeText(UserProfileActivity.this,"Please try again later",Toast.LENGTH_SHORT).show();
                            return;
                        }


                    }
                });

    }

public void log(View view){
        Intent bo=new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(bo);

    //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
    public void datastore(){
        String email=editTextEmail.getText().toString().trim();
        String name=editTextName.getText().toString().trim();
        String mobile=editTextMobile.getText().toString().trim();
        String date=editTextDate.getText().toString().trim();
        RadioGroup rg=(RadioGroup)findViewById(R.id.rgroup);
        String gender=((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();
        Spinner myspinner=(Spinner)findViewById(R.id.State1);
        String state=myspinner.getSelectedItem().toString();
        if(TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this,"Enter your Email",Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(name)){
            // password is empty
            Toast.makeText(this,"Enter your Name",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(mobile)){
            //email is empty
            Toast.makeText(this,"Enter your Mobile",Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(date)){
            // password is empty
            Toast.makeText(this,"Enter your Date of birth",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(gender)){
            // password is empty
            Toast.makeText(this,"Enter your Gender",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(state)){
            // password is empty
            Toast.makeText(this,"Enter your State",Toast.LENGTH_SHORT).show();
            return;
        }


    }


}

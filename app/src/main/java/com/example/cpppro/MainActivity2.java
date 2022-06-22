package com.example.cpppro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {

    EditText mFullName,mPassword;
    TextView mLogOnRegister;
    Button mRegLog;
    FirebaseAuth fAuth;
    ProgressBar progressBar;



    public void onBackPressed(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mFullName = findViewById(R.id.editTextTextPersonName);
        mPassword = findViewById(R.id.editTextTextPassword2);
        mRegLog = findViewById(R.id.buttonLogin);
        mLogOnRegister = findViewById(R.id.loginOnReg);


        fAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar3);

        if(fAuth.getCurrentUser()  !=null) {
            startActivity(new Intent(getApplicationContext(),MainActivity3.class));
            finish();
        }


        mRegLog.setOnClickListener(view -> {
            String name = mFullName.getText().toString().trim();
            String password = mPassword.getText().toString().trim();

            if(TextUtils.isEmpty(name)){
                mFullName.setError("Username is Required");
                return;
            }
            if(TextUtils.isEmpty(password)){
                mPassword.setError("Password is required");
                return;
            }
            if(password.length()<6){
                mPassword.setError("Password must be more than 6 character");
                return;
            }

            progressBar.setVisibility(View.VISIBLE);

            fAuth.createUserWithEmailAndPassword(name,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(MainActivity2.this, "Successful Registered", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),MainActivity3.class));
                        finish();
                    }
                    else {
                        Toast.makeText(MainActivity2.this, "Error "+ task.getException(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);

                    }
                }
            });

        });
        mLogOnRegister.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(),Login.class)));
    }




}

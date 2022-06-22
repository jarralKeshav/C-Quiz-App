package com.example.cpppro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgetActivity extends AppCompatActivity {
    private Button mforgetBtn;
    private EditText mEmail;
    private String email;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        fAuth = FirebaseAuth.getInstance();

        mEmail = findViewById(R.id.forgetEmail);
        mforgetBtn = findViewById(R.id.buttonForgetEmail);

        mforgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });


    }

    private void validateData() {
        email = mEmail.getText().toString();
        if(email.isEmpty())
        {
            mEmail.setError("Required");
        }else{
            forgetPassword();
        }
    }

    private void forgetPassword() {
        fAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(forgetActivity.this, "Check your Email", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),Login.class));
                    finish();
                }
                else{
                    Toast.makeText(forgetActivity.this, "Erroe "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
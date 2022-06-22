package com.example.cpppro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultScreen extends AppCompatActivity {
    TextView resultText;
    int correctAnswers;
    Button mTryAgainBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        resultText = findViewById(R.id.textView8);
        mTryAgainBtn = findViewById(R.id.tryAgainBtn);

        correctAnswers= getIntent().getIntExtra("correct",0);
        resultText.setText(correctAnswers + "/10");


        mTryAgainBtn.setOnClickListener(view -> {

            startActivity(new Intent(getApplicationContext(),MainActivity3.class));
        });

    }


}
package com.example.cpppro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity4 extends AppCompatActivity {


    private ScrollView scroll;
    private RadioGroup radioGroupOne;
    private RadioGroup radioGroupTwo;
    private RadioGroup radioGroupThree;
    private RadioGroup radioGroupFour;
    private RadioGroup radioGroupFive;
    private RadioGroup radioGroupSix;
    private RadioGroup radioGroupSeven;
    private RadioGroup radioGroupEight;
    private RadioGroup radioGroupNine;
    private RadioGroup radioGroupTen;
    private RadioButton question1;
    private RadioButton question2;
    private RadioButton question3;
    private RadioButton question4;
    private RadioButton question5;
    private RadioButton question6;
    private RadioButton question7;
    private RadioButton question8;
    private RadioButton question9;
    private RadioButton question10;
    public int correctAnswers;
    Button mSubmitbutton;
    Button mResetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        scroll = (ScrollView) findViewById(R.id.Scroll);

        question1 = (RadioButton) findViewById(R.id.rb_CorrectAnsOne);
        question2 = (RadioButton) findViewById(R.id.rb_CorrectAnsTwo);
        question3 = (RadioButton) findViewById(R.id.rb_CorrectAnsThree);
        question4 = (RadioButton) findViewById(R.id.rb_CorrectAnsFour);
        question5 = (RadioButton) findViewById(R.id.rb_CorrectAnsFive);
        question6 = (RadioButton) findViewById(R.id.rb_CorrectAnsSix);
        question7 = (RadioButton) findViewById(R.id.rb_CorrectAnsSeven);
        question8 = (RadioButton) findViewById(R.id.rb_CorrectAnsEight);
        question9 = (RadioButton) findViewById(R.id.rb_CorrectAnsNine);
        question10 = (RadioButton) findViewById(R.id.rb_CorrectAnsTen);


        radioGroupOne = (RadioGroup) findViewById(R.id.radioGroupOne);
        radioGroupTwo = (RadioGroup) findViewById(R.id.radioGroupTwo);
        radioGroupThree = (RadioGroup) findViewById(R.id.radioGroupThree);
        radioGroupFour = (RadioGroup) findViewById(R.id.radioGroupFour);
        radioGroupFive = (RadioGroup) findViewById(R.id.radioGroupFive);
        radioGroupSix = (RadioGroup) findViewById(R.id.radioGroupSix);
        radioGroupSeven = (RadioGroup) findViewById(R.id.radioGroupSeven);
        radioGroupEight = (RadioGroup) findViewById(R.id.radioGroupEight);
        radioGroupNine = (RadioGroup) findViewById(R.id.radioGroupNine);
        radioGroupTen = (RadioGroup) findViewById(R.id.radioGroupTen);

        mSubmitbutton = (Button) findViewById(R.id.submit_Button_Quiz);
        mResetButton = (Button)findViewById(R.id.all);

        mSubmitbutton.setOnClickListener(view -> {

            String wrongAnswers = "Check this question and try again :-\n";

            if(question1.isChecked()){
                correctAnswers++;
            }else{
                wrongAnswers = wrongAnswers + "Question - 1\n";
            }
            if(question2.isChecked()){
                correctAnswers++;
            }else{
                wrongAnswers = wrongAnswers + "Question - 2\n";
            }
            if(question3.isChecked()){
                correctAnswers++;
            }else{
                wrongAnswers = wrongAnswers + "Question - 3\n";
            }
            if(question4.isChecked()){
                correctAnswers++;
            }else{
                wrongAnswers = wrongAnswers + "Question - 4\n";
            }
            if(question5.isChecked()){
                correctAnswers++;
            }else{
                wrongAnswers = wrongAnswers + "Question - 5\n";
            }
            if(question6.isChecked()){
                correctAnswers++;
            }else{
                wrongAnswers = wrongAnswers + "Question - 6\n";
            }
            if(question7.isChecked()){
                correctAnswers++;
            }else{
                wrongAnswers = wrongAnswers + "Question - 7\n";
            }
            if(question8.isChecked()){
                correctAnswers++;
            }else{
                wrongAnswers = wrongAnswers + "Question - 8\n";
            }
            if(question9.isChecked()){
                correctAnswers++;
            }else{
                wrongAnswers = wrongAnswers + "Question - 9\n";
            }
            if(question10.isChecked()){
                correctAnswers++;
            }else{
                wrongAnswers = wrongAnswers + "Question - 10\n";
            }

            if(correctAnswers==10){
                Toast.makeText(MainActivity4.this, "Congrats, All Answers are Correct \n", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(MainActivity4.this, "Correct Answers: "+correctAnswers + "/10\n" + wrongAnswers, Toast.LENGTH_SHORT).show();

            }
            Intent intent = new Intent(MainActivity4.this, ResultScreen.class);
            intent.putExtra("correct",correctAnswers);
            startActivity(intent);

            finish();


        });
        mResetButton.setOnClickListener(view -> {
            correctAnswers=0;
            radioGroupOne.clearCheck();
            radioGroupTwo.clearCheck();
            radioGroupThree.clearCheck();
            radioGroupFour.clearCheck();
            radioGroupFive.clearCheck();
            radioGroupSix.clearCheck();
            radioGroupSeven.clearCheck();
            radioGroupEight.clearCheck();
            radioGroupNine.clearCheck();
            radioGroupTen.clearCheck();


            scroll.fullScroll(ScrollView.FOCUS_UP);
        });


    }
    public void onBackPressed(){
    }
}
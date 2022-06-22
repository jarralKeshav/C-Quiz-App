package com.example.cpppro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void openActivity2(View v){
        Toast.makeText(this, "Opening General Quiz", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),MainActivity4.class);
        startActivity(intent);
    }
    public void openActivity3(View v){
        Toast.makeText(this, "Opening Quiz on Loops", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),LoopQuizis.class));
    }
    public void openActivity4(View v){
        Toast.makeText(this, "Opening Conditional Quiz", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),Conditional.class));
    }
    public void openActivity5(View v){
        Toast.makeText(this, "Opening Array Quiz", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),Arrayz.class));
    }
    public void openActivity6(View v){
        Toast.makeText(this, "Opening String Quiz", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(),Strings.class));
    }
    public void onBackPressed(){
    }

    public void Logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}
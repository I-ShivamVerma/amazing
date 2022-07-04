package com.example.amazing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity {

    private String[] questions = {"1. Shivam is the richest person in the world?","2. Jeff Bezos is the founder of Amazon company?",
            "3. Amazon is introduced in 1999?", "4. Is Amazon the longest river in the world?", "5. Amazon.com is one of the largest e-commerce company?",
    "6. Is Jeff Bezos richer than Elon Musk?","7. Moto is my girlfriend?"};

    private boolean[] answers = {true, true, false, true, true, false, true};

    private int score =0;
    Button yes;
    Button no;
    Button submit;
    TextView question;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yes = findViewById(R.id.btnYes);
        no = findViewById(R.id.btnNo);
        submit = findViewById(R.id.btnSubmit);
        question = findViewById(R.id.txtQuestion);
        question.setText(questions[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(index <= questions.length - 1){

                    if(answers[ index ]){
                        score++;
                    }
                    ++index;
                    if(index <= questions.length - 1){
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(index <= questions.length - 1){

                    if(!answers[ index ]){
                        score++;
                    }
                    ++index;
                    if(index <= questions.length - 1){
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                System.exit(0);
            }
        });
    }
}
package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecommendActivity extends AppCompatActivity {

    Button button1;
    Button button2;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;

    int startNumber = 1;
    int endNumber = 45;
    int order = 1;

    List<Integer> allNumber = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        for(int i=1; i<46; i++){
            allNumber.add(i);
        }
        Collections.shuffle(allNumber);

        SpannableString content = new SpannableString("?");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);

        textView1.setText(content);
        textView2.setText(content);
        textView3.setText(content);
        textView4.setText(content);
        textView5.setText(content);
        textView6.setText(content);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(order > 6){
                    resetRandomNumber();
//                }
//                printRandomNumber();
                clickRandomButton();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetRandomNumber();
            }
        });
    }

    private int getRandomNumber(){
        return allNumber.get(order-1);
    }

    private void printRandomNumber(){
        int newNumber = getRandomNumber();
        startNumber = newNumber+1;
        endNumber++;

        switch (order){
            case 1:
                textView1.setText(String.valueOf(newNumber));
                break;
            case 2:
                textView2.setText(String.valueOf(newNumber));
                break;
            case 3:
                textView3.setText(String.valueOf(newNumber));
                break;
            case 4:
                textView4.setText(String.valueOf(newNumber));
                break;
            case 5:
                textView5.setText(String.valueOf(newNumber));
                break;
            case 6:
                textView6.setText(String.valueOf(newNumber));
                break;
        }

        order++;
    }

    private void nextRandomNumber(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                printRandomNumber();
                if(order < 7){
                    nextRandomNumber();
                }
            }
        }, 500);
    }

    private void clickRandomButton(){
        printRandomNumber();
        nextRandomNumber();
    }

    private void resetRandomNumber(){
        order = 1;
        Collections.shuffle(allNumber);
        textView1.setText("?");
        textView2.setText("?");
        textView3.setText("?");
        textView4.setText("?");
        textView5.setText("?");
        textView6.setText("?");
    }
}
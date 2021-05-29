package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button lottoButton;
    Button recommendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottoButton = (Button) findViewById(R.id.mainBtn1);
        recommendButton = (Button) findViewById(R.id.mainBtn2);

//        lottoButton.setOnClickListener((view) -> {
//            goLotto();
//        });
//        recommendButton.setOnClickListener((view) -> {
//            goRecommend();
//        });
    }

    private void goLotto(){
        Intent intent = new Intent(getApplicationContext(), LottoActivity.class);
        startActivity(intent);
        finish();
    }

    private void goRecommend(){
        Intent intent = new Intent(getApplicationContext(), RecommendActivity.class);
        startActivity(intent);
        finish();
    }
}

package com.example.mad_ass_03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        int score = 0;
        Bundle extras = getIntent().getExtras();
        if (extras != null ) {
            score = extras.getInt("score");
        }

        ((TextView) findViewById(R.id.resultTV)).setText(String.format("Your score is %s", String.valueOf(score)));

        ((Button) findViewById(R.id.goBackBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
            }
        });
    }
}
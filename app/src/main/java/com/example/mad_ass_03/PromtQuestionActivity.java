package com.example.mad_ass_03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class PromtQuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promt_question);

        TextView scoreTV = findViewById(R.id.scoreTV);
        Bundle extras = getIntent().getExtras();
        String question = "";
        String correctOps = "";
        int score = 0;
        int index = 0;
        ArrayList<String> options = new ArrayList<>();
        if (extras != null ) {
//            question = extras.getString("question");
//            correctOps = extras.getString("correctOps");
//            options = (ArrayList<String>) extras.getSerializable("options");
            score = extras.getInt("score");
            index = extras.getInt("index");
        }

        if(index==0){
            question = "What is the capital of Bangladesh?";
            correctOps = "Dhaka";
            options = new ArrayList<>(Arrays.asList("New York", "Dubai", "Kuala Lampur", "Dhaka", "Chittagong"));
        }
        else if(index==1){
            question = "Do you like Android Development using Android Studio?";
            correctOps = "No";
            options = new ArrayList<>(Arrays.asList("Yes", "No"));
        }
        else if(index==2){
            question = "Option four is correct";
            correctOps = "four";
            options = new ArrayList<>(Arrays.asList("one", "two", "three", "four"));
        }
        else if(index==3){
            question = "Option one is correct";
            correctOps = "one";
            options = new ArrayList<>(Arrays.asList("one", "two", "three", "four"));
        }
        else if(index==4){
            question = "Option three is correct";
            correctOps = "three";
            options = new ArrayList<>(Arrays.asList("one", "two", "three", "four"));
        }
        else if(index==5){
            startActivity(new Intent(PromtQuestionActivity.this, ResultActivity.class).putExtra("score", score) );
        }

        ((TextView)findViewById(R.id.questionText)).setText(question);
        scoreTV.setText(String.valueOf(score));
        RecyclerView recView = findViewById(R.id.opsRecView);

        ArrayList<OptionsDataModel> opsDataList = new ArrayList<>();
        for (String op : options) {
            opsDataList.add(new OptionsDataModel(op, (op.equals(correctOps))));
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        OptionsAdapter adapter = new OptionsAdapter(this, opsDataList, correctOps, scoreTV, index);
        recView.setLayoutManager(linearLayoutManager);
        recView.setAdapter(adapter);
    }
}
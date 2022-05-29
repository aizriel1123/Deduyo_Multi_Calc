package com.example.deduyo_multi_calc.controller.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.deduyo_multi_calc.R;

import java.util.Objects;

import com.example.deduyo_multi_calc.controller.controller.controller;


public class physics extends AppCompatActivity {


    TextView x1, x2, x3, answer;
    EditText input1, input2;
    Button calculate, back;

    controller controller = new controller();

    @SuppressLint("SourceLockedOrientationActivity")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.physicsmain);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        x1 = findViewById(R.id.x1);
        x2 = findViewById(R.id.x2);
        x3 = findViewById(R.id.x3);
        answer = findViewById(R.id.answer);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        calculate = findViewById(R.id.button);
        back = findViewById(R.id.back2);

        Intent object = getIntent();
        String concept = object.getStringExtra("concept");

        calculate.setOnClickListener(v -> {
            double x1 = Double.parseDouble(input1.getText().toString());
            double x2 = Double.parseDouble(input2.getText().toString());
            controller.physics(x1, x2, concept);
            controller.physicsAnswer(answer);
        });
        back.setOnClickListener(v -> {
            Intent back = new Intent(this, MainActivity.class);
            startActivity(back);
        });

        controller.physicsOutput(x1, x2, x3, concept);
    }
}



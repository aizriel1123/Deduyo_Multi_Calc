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

import com.example.deduyo_multi_calc.controller.controller.controller;

public class geometry extends AppCompatActivity {

    TextView shape, y1, y2, y3, y4, y5, answer1, answer2;
    EditText inputI, inputII, inputIII;
    Button calculate, back;

    controller controller = new controller();

    @SuppressLint("SourceLockedOrientationActivity")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.geometrymain);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        shape = findViewById(R.id.shape);
        y1 = findViewById(R.id.y1);
        y2 = findViewById(R.id.y2);
        y3 = findViewById(R.id.y3);
        y4 = findViewById(R.id.y4);
        y5 = findViewById(R.id.y5);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        inputI = findViewById(R.id.inputI);
        inputII = findViewById(R.id.inputII);
        inputIII = findViewById(R.id.inputIII);
        calculate = findViewById(R.id.calculate);
        back = findViewById(R.id.back3);

        Intent object = getIntent();
        String Shape = object.getStringExtra("shape");

        calculate.setOnClickListener(v -> {
            double y1 = Double.parseDouble(inputI.getText().toString());
            double y2 = Double.parseDouble(inputII.getText().toString());
            double y3 = Double.parseDouble(inputIII.getText().toString());
            controller.geometry(y1, y2, y3, Shape);
            controller.geometryAnswer(answer1, answer2);
        });
        back.setOnClickListener(v -> {
            Intent back = new Intent(this, MainActivity.class);
            startActivity(back);
        });

        controller.geometryOutput(shape, y1, y2, y3, Shape, inputII, inputIII);
    }
}

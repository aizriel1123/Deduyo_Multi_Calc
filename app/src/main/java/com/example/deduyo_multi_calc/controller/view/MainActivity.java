package com.example.deduyo_multi_calc.controller.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.deduyo_multi_calc.R;
import com.example.deduyo_multi_calc.controller.model.model;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button physics, geometry, velocity, force, weight, density, voltage, hemisphere, sphere, cylinder, cone, back;

    model object = new model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        physics = findViewById(R.id.physics);
        geometry = findViewById(R.id.geometry);
        velocity = findViewById(R.id.velocity);
        force = findViewById(R.id.force);
        weight = findViewById(R.id.weight);
        density = findViewById(R.id.density);
        voltage = findViewById(R.id.voltage);
        hemisphere = findViewById(R.id.hemisphere);
        sphere = findViewById(R.id.sphere);
        cylinder = findViewById(R.id.cylinder);
        cone = findViewById(R.id.cone);
        back = findViewById(R.id.back1);

        physics.setOnClickListener(this);
        geometry.setOnClickListener(this);
        velocity.setOnClickListener(this);
        force.setOnClickListener(this);
        weight.setOnClickListener(this);
        density.setOnClickListener(this);
        voltage.setOnClickListener(this);
        hemisphere.setOnClickListener(this);
        sphere.setOnClickListener(this);
        cylinder.setOnClickListener(this);
        cone.setOnClickListener(this);
        back.setOnClickListener(this);

        start();
    }


    @Override
    @SuppressLint("NonConstantResourceId")
    public void onClick(View view) {
        Intent physics = new Intent(MainActivity.this,physics.class);
        Intent geometry = new Intent(MainActivity.this,geometry.class);
        switch (view.getId()) {
            case R.id.physics:
                physics();
                break;
            case R.id.geometry:
                geometry();
                break;
            case R.id.back1:
                start();
                break;
            case R.id.velocity:
                object.setConcept("Velocity");
                physics.putExtra("concept", object.getConcept());
                startActivity(physics);
                break;
            case R.id.force:
                object.setConcept("Force");
                physics.putExtra("concept", object.getConcept());
                startActivity(physics);
                break;
            case R.id.weight:
                object.setConcept("Weight");
                physics.putExtra("concept", object.getConcept());
                startActivity(physics);
                break;
            case R.id.density:
                object.setConcept("Density");
                physics.putExtra("concept", object.getConcept());
                startActivity(physics);
                break;
            case R.id.voltage:
                object.setConcept("Voltage");
                physics.putExtra("concept", object.getConcept());
                startActivity(physics);
                break;
            case R.id.hemisphere:
                object.setShape("CAPSULE");
                geometry.putExtra("shape", object.getShape());
                startActivity(geometry);
                break;
            case R.id.sphere:
                object.setShape("SPHERE");
                geometry.putExtra("shape", object.getShape());
                startActivity(geometry);
                break;
            case R.id.cylinder:
                object.setShape("CYLINDER");
                geometry.putExtra("shape", object.getShape());
                startActivity(geometry);
                break;
            case R.id.cone:
                object.setShape("CONE");
                geometry.putExtra("shape", object.getShape());
                startActivity(geometry);
        }
    }

    public void start() {
        velocity.setVisibility(View.GONE);
        force.setVisibility(View.GONE);
        weight.setVisibility(View.GONE);
        density.setVisibility(View.GONE);
        voltage.setVisibility(View.GONE);
        hemisphere.setVisibility(View.GONE);
        sphere.setVisibility(View.GONE);
        cylinder.setVisibility(View.GONE);
        cone.setVisibility(View.GONE);
        physics.setVisibility(View.VISIBLE);
        geometry.setVisibility(View.VISIBLE);
        back.setVisibility(View.GONE);
    }

    public void physics() {
        velocity.setVisibility(View.VISIBLE);
        force.setVisibility(View.VISIBLE);
        weight.setVisibility(View.VISIBLE);
        density.setVisibility(View.VISIBLE);
        voltage.setVisibility(View.VISIBLE);
        hemisphere.setVisibility(View.GONE);
        sphere.setVisibility(View.GONE);
        cylinder.setVisibility(View.GONE);
        cone.setVisibility(View.GONE);
        physics.setVisibility(View.GONE);
        geometry.setVisibility(View.GONE);
        back.setVisibility(View.VISIBLE);
    }

    public void geometry() {
        velocity.setVisibility(View.GONE);
        force.setVisibility(View.GONE);
        weight.setVisibility(View.GONE);
        density.setVisibility(View.GONE);
        voltage.setVisibility(View.GONE);
        hemisphere.setVisibility(View.VISIBLE);
        sphere.setVisibility(View.VISIBLE);
        cylinder.setVisibility(View.VISIBLE);
        cone.setVisibility(View.VISIBLE);
        physics.setVisibility(View.GONE);
        geometry.setVisibility(View.GONE);
        back.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}

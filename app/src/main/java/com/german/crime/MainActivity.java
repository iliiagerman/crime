package com.german.crime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.german.crime.programm2.CrimeListActivity;
import com.german.crime.programm1.QuizActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pro1 = findViewById(R.id.programa1);
        Button pro2 = findViewById(R.id.programa2);
        Button pro3 = findViewById(R.id.programa3);
        pro1.setOnClickListener(this);
        pro2.setOnClickListener(this);
        pro3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.programa1:
                Intent intent = new Intent(this, QuizActivity.class);
                startActivity(intent);
                break;
            case R.id.programa2:
                Intent intent1 = new Intent(this, CrimeListActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}
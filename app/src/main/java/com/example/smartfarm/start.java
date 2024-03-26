package com.example.smartfarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class start extends AppCompatActivity {

    Button bst,bw,bco,bci;
    Button bcnec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        bst = findViewById(R.id.button3);
        bw = findViewById(R.id.button5);
        bco = findViewById(R.id.button4);
        bci = findViewById(R.id.button7);
      //  bcnec = findViewById(R.id.button6);

        bst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(start.this, statistics.class);
                startActivity(intent);
            }


        });

        bw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(start.this, MainActivity.class);
                startActivity(intent);
            }


        });

       bco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(start.this, manual_control.class);
                startActivity(intent);
            }


        });

        bci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(start.this,CropInformation.class);
                startActivity(intent);
            }


        });

     /*   bcnec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(start.this, manual_control.class);
                startActivity(intent);
            }


        }); */
    }
}
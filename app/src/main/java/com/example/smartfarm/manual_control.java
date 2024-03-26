package com.example.smartfarm;

//import static com.example.firbaseauth.R.id.led_switch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class manual_control extends AppCompatActivity {

    private Switch ledSwitch;
    private DatabaseReference ledRef;
    private Button acbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_control);

        // Initialize Firebase Database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ledRef = database.getReference("LED State: ");

        // Initialize Switch
        ledSwitch = findViewById(R.id.led_switch);
        acbutton = findViewById(R.id.button);

        // Add listener to the switch
        ledSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Update LED status in Firebase
                if (isChecked) {
                    ledRef.setValue("ON");
                } else {
                    ledRef.setValue("OFF");
                }
            }
        });

        // Listen for changes in the LED status
        ledRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String status = dataSnapshot.getValue(String.class);
                if (status != null) {
                    if (status.equals("ON")) {
                        ledSwitch.setChecked(true);
                    } else {
                        ledSwitch.setChecked(false);
                    }
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(manual_control.this, "Failed to read LED status.", Toast.LENGTH_SHORT).show();
            }
        });

        acbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(manual_control.this, Acontrol.class);
                startActivity(intent);
            }


        });

    }
}

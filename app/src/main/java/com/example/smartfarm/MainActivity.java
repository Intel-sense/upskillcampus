package com.example.smartfarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {


 Button button , confirmButton;
   //      FirebaseUser user;
      //   TextView textView;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // auth = FirebaseAuth.getInstance();
        button = findViewById(R.id.logout);
     //   textView = findViewById(R.id.user_details);
      //  user = auth.getCurrentUser();
        confirmButton = findViewById(R.id.confirm_button);
     /*   if(user == null)
        {
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
        }
        else {
        textView.setText(user.getEmail());
        }
        button.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
        finish();
        }

        }); */


        confirmButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick (View v) {
        Intent intent = new Intent(MainActivity.this, manual_control.class);
        startActivity(intent);
        }


        });


}
}
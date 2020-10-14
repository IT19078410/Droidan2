package com.example.droidan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Mainpage extends AppCompatActivity {

    Button btnLogin, btnOwner, btnSignUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       ViewPager viewPager = findViewById(R.id.viewPager);
       ImageAdapter adapter = new ImageAdapter(this);
       viewPager.setAdapter(adapter);

        btnLogin = findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainpage.this, Loginn.class);
                startActivity(i);

            }
        });

        btnSignUp = findViewById(R.id.Signup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainpage.this, CustomerRegistration.class);
                startActivity(i);

            }
        });

        btnOwner = findViewById(R.id.owner);
        btnOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Mainpage.this, OwnerRegistration.class);
                startActivity(i);
            }
        });
    }


}
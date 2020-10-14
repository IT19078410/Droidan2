package com.example.droidan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private EditText phoneno,
            password;
    private Button login,
            register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        phoneno =findViewById(R.id.phonen2);
                password =findViewById(R.id.password2n);
        login =findViewById(R.id.login2n);
                register =findViewById(R.id.registern);
                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(Login.this, HomePage.class);
                        startActivity(i);
                    }
                });
       // // login.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View view) {
        //         DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        //         databaseReference.child("Login").addValueEventListener(new ValueEventListener() {
        //             @Override
        //             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        //                 String input1 =phoneno.getText().toString();
        //                 String input2 =password.getText().toString();
//
//
        //                 if(dataSnapshot.child(input1).exists()){
        //                     if (dataSnapshot.child(input2).exists()){
//
        //                     }
        //                       else {
        //                             Toast.makeText(Login.this,"Invalid Password",Toast.LENGTH_SHORT).show();
        //                         }
//
        //             }
        //                 else {
        //                     Toast.makeText(Login.this,"Invalid phone Number",Toast.LENGTH_SHORT).show();
        //                 }
        //             }
//
        //             @Override
        //             public void onCancelled(@NonNull DatabaseError databaseError) {
//
        //             }
        //         });
             }
        // });

    }

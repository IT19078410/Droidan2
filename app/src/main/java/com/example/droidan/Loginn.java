package com.example.droidan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Loginn extends AppCompatActivity {
    EditText Phoneno,password;
    Button login,reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginn);
        Phoneno=(EditText) findViewById(R.id.phonen2);
        password=(EditText) findViewById(R.id.password2n);
        login=(Button) findViewById(R.id.login2n);
        reg=(Button) findViewById(R.id.registern);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Loginn.this, CustomerRegistration.class);
                startActivity(i);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
                databaseReference.child("Owners").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String input1 =Phoneno.getText().toString();
                        String input2 =password.getText().toString();

                        if(snapshot.child(input1).exists()){
                            if(snapshot.child(input2).exists()){
                                if(snapshot.child(input1).equals("123")){
                                    Preferences.setDataLogin(Loginn.this,true);
                                    Preferences.setDataAs(Loginn.this,"123");
                                    Intent i = new Intent(Loginn.this, AdminCustomer.class);
                                    startActivity(i);
                                }else {
                                    Preferences.setDataLogin(Loginn.this,true);
                                    Intent i = new Intent(Loginn.this, HomePage.class);
                                    startActivity(i);
                                }

                            } else {
                                Toast.makeText(Loginn.this, "password  does not exist", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Loginn.this, "Phone number does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}
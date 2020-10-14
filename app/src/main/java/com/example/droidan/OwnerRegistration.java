package com.example.droidan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class OwnerRegistration extends AppCompatActivity {

    private EditText cname, cphoneno, cpassword, cconfirmpassword,email;
    private ProgressDialog loadingbar;
    Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_registration);

        cname = (EditText) findViewById(R.id.editTextTextPersonName);
        cphoneno = (EditText) findViewById(R.id.phoneno);
        cpassword = (EditText) findViewById(R.id.password2n);
        email=(EditText) findViewById(R.id.email);
        submit=(Button) findViewById(R.id.Register1) ;
        loadingbar = new ProgressDialog(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateAccount();
                Intent i = new Intent(OwnerRegistration.this, OwnerPage.class);
                startActivity(i);
            }
        });

    }

    private void CreateAccount() {
        String name = cname.getText().toString();
        String phoneno = cphoneno.getText().toString();
        String password = cpassword.getText().toString();
        String oemail = email.getText().toString();

        if (TextUtils.isEmpty(name)) {
            Toast.makeText(this, "Insert name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(phoneno)) {
            Toast.makeText(this, "Insert phone number", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Insert password", Toast.LENGTH_SHORT).show();
        } else {
            loadingbar.setTitle("Create Account");
            loadingbar.setMessage("Please wait..");
            loadingbar.setCanceledOnTouchOutside(false);
            loadingbar.show();

            ValidatePhone(name, phoneno, password,oemail);

        }
    }

    private void ValidatePhone(final String name, final String phoneno, final String password,final String owemail) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Owners").child(phoneno).exists())) {
                    HashMap<String, Object>ownerdatamap = new HashMap<>();
                    ownerdatamap.put("phoneno", phoneno);
                    ownerdatamap.put("name", name);
                    ownerdatamap.put("password", password);
                    ownerdatamap.put("email",owemail);

                    RootRef.child("Customers").child(phoneno).updateChildren(ownerdatamap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(OwnerRegistration.this, "Acoount created succesfully", Toast.LENGTH_SHORT).show();
                                        loadingbar.dismiss();

                                        Intent i = new Intent(OwnerRegistration.this, OwnerPage.class);
                                        startActivity(i);
                                    } else {
                                        loadingbar.dismiss();
                                        Toast.makeText(OwnerRegistration.this, "Please try again later", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(OwnerRegistration.this, "This phone number already exists", Toast.LENGTH_SHORT).show();
                    loadingbar.dismiss();

                    Intent i = new Intent(OwnerRegistration.this, OwnerRegistration.class);
                    startActivity(i);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
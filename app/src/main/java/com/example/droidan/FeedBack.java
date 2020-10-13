package com.example.droidan;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Build;
import android.os.Bundle;
import android.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBack extends AppCompatActivity {


    Button Submit;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText nameField = (EditText) findViewById(R.id.EditText_Enter_your_name);
        String name = nameField.getText().toString();

        final EditText emailField = (EditText) findViewById(R.id.EditText_Enter_your_Email);
        String email = emailField.getText().toString();

        final EditText feedbackField = (EditText) findViewById(R.id.EditText_FeedbackBody);
        String feedback = feedbackField.getText().toString();

        final CheckBox responseCheckbox = (CheckBox) findViewById(R.id.CheckBoxResponse);
        boolean bRequiresResponse = responseCheckbox.isChecked();

        Submit=(Button)findViewById(R.id.ButtonSendFeedback);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FeedBack.this,"Thanks! Your Feedback is submitted.",Toast.LENGTH_LONG).show();
            }
        });

    }
}
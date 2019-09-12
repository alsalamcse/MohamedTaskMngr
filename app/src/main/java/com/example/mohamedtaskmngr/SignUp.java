package com.example.mohamedtaskmngr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    private EditText etFirstName,etLastName,etPhone,etEmail,etPassword,etRePassword;
    private Button btnSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
       etFirstName=findViewById(R.id.etFirstName);
       etLastName=findViewById(R.id.etLastName);
       etPhone=findViewById(R.id.etPhone);
       etEmail=findViewById(R.id.etpassword);
       etPassword=findViewById(R.id.etpassword);
       etRePassword=findViewById(R.id.etRePassword);
       btnSave=findViewById(R.id.btnSave);
    }
}

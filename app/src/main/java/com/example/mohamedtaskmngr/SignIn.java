package com.example.mohamedtaskmngr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignIn extends AppCompatActivity {
    private EditText etemail,etpassword;
    private Button btnsignin,btnsignup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        etemail=findViewById(R.id.etEmail);
        etpassword=findViewById(R.id.etpassword);
        btnsignin=findViewById(R.id.btnsignin);
        btnsignup=findViewById(R.id.btnsignup);


    }
}

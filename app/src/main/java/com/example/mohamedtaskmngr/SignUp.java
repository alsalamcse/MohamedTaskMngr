package com.example.mohamedtaskmngr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private EditText etFirstName, etLastName, etPhone, etEmail, etPassword, etRePassword;
    private Button btnSave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etRePassword = findViewById(R.id.etRePassword);
        btnSave = findViewById(R.id.btnSave);


        btnSave.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();

            }
        });

    }


    private void dataHandler() {
        String email = etEmail.getText().toString();
        String passw = etPassword.getText().toString();
        String firstname = etFirstName.getText().toString();
        String lastname = etLastName.getText().toString();
        String repassword = etRePassword.getText().toString();
        String phone = etPhone.getText().toString();
        boolean isok = true;
        if (email.length() < 4 ||
                email.indexOf('@') < 0 ||
                email.indexOf('.') < 0) {
            etEmail.setError("Invalid Email");
            isok = false;

        }
        if (passw.length() < 8 || passw.equals(repassword) == false) {
            etPassword.setError("Have To Be At Least 8 char and the same password");
            etRePassword.setError("Have To Be At Least 8 char and the same password");

            isok = false;
        }
        if (firstname.length() == 0) {
            etFirstName.setError("Enter Name");
            isok = false;
        }
        if (isok) {
            creatAcount(email, firstname, lastname, phone, passw);

            //Creat Acount(email,password)

        }

    }

    private void creatAcount(String email, String firstname, String lastname, String phone, String passw) {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUp.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                    finish();

                } else {
                    etEmail.setError("Sign Up failed");

                }
            }
        });
    }
}








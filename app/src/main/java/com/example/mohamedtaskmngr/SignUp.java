package com.example.mohamedtaskmngr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private EditText    etEmail, etPassword, etRePassword;
    private Button btnContinue,btnSave;
    private CheckBox chManager;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etRePassword = findViewById(R.id.etRePassword);
        btnContinue = findViewById(R.id.btnContinue);
        chManager = findViewById(R.id.chManager);
        btnSave=findViewById(R.id.btnSave);
       btnContinue=findViewById(R.id.btnContinue);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });

    }



    private void dataHandler() {
        final String email = etEmail.getText().toString();
        final String passw = etPassword.getText().toString();
        String repassword = etRePassword.getText().toString();

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
        {

        }
        if (chManager.isChecked()) {
            btnContinue.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent i=new Intent(getApplication(),Manager.class);
                   startActivity(i);

               }
           });

        }
        else {
            btnContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent u=new Intent(getApplication(),Client.class);
                    startActivity(u);

                }
            });
        }
        if (isok){
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    creatAcount(email,passw);
                }
            });







                }


        }






    private void creatAcount(final String email, String passw) {

        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUp.this, "Sign Up Successful", Toast.LENGTH_SHORT).show();
                    finish();

                }
                else {
                    etEmail.setError("Sign up Failed");
                }
            }
        });
    }
}








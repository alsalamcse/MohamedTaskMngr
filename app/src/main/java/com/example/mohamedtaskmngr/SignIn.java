package com.example.mohamedtaskmngr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

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


        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();

            }

        });

        }

    private void dataHandler() {
        String email=etemail.getText().toString();
        String passw=etpassword.getText().toString();
        boolean isok=true;
//        if (email.length()<4)
//        {
//            etemail.setError("Email length error");
//            isok=false;
//        }
//        if (email.indexOf("@")<0 || email.indexOf(".")<0)
//        {
//            etemail.setError("Email wrong format");
//            isok= false;
//        }
//        if (passw.length()<8)
//        {
//            etpassword.setError("password length error");
//            isok=false;
//        }
        if(isValidEmailAddress(email)==false){
            etemail.setError("Invalid Email");
            isok=false;

        }
        if (isok){

        }

    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    private void signIn(String email,String passw){

        FirebaseAuth  auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email, passw);
    }


}









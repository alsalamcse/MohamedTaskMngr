package com.example.mohamedtaskmngr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohamedtaskmngr.data.MyClient;
import com.example.mohamedtaskmngr.data.MyManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Client extends AppCompatActivity {
    private EditText etFirstName2, etLastName2, etPhone3;
    private Button btnSave2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
        etFirstName2 = findViewById(R.id.etFirstName2);
        etLastName2 = findViewById(R.id.etLastName2);
        etPhone3 = findViewById(R.id.etPhone3);
        btnSave2 = findViewById(R.id.btnSave2);
    }

    private void dataHandler1() {
        String firstname = etFirstName2.getText().toString();
        String Lastname = etLastName2.getText().toString();
        String phone = etPhone3.getText().toString();


        boolean isok2 = true;
        if (firstname.length() == 0) {
            etFirstName2.setError("Enter Name");
            isok2 = false;

        }
        if (isok2) {
            MyClient C = new MyClient();
            C.setEtFirstName2(firstname);
            C.setEtLastName2(Lastname);
            C.getEtPhone3(phone);
            creatMyClient(C);
        }

        }

        private void creatMyClient(MyClient C) {                                    //save in data base ******important
            //1.building object in data base
            FirebaseDatabase database=FirebaseDatabase.getInstance();
            FirebaseAuth auth= FirebaseAuth.getInstance();  //to get user uid  //1
            String uid = auth.getCurrentUser().getUid();
            C.setOwner(uid);
            //2.

            DatabaseReference reference = database.getReference();
            String key = reference.child("tasks").push().getKey();
            C.setKey(key);
            reference.child("tasks").child(uid).child(key).setValue(C).addOnCompleteListener(Client.this, new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Client.this, "add successful", Toast.LENGTH_SHORT).show();
                        finish();

                    }
                    else {
                        Toast.makeText(Client.this, "add failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        task.getException().printStackTrace();


                    }
                }
            });          ///
    }
}

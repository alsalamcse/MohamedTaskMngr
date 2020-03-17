package com.example.mohamedtaskmngr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohamedtaskmngr.data.MyManager;
import com.example.mohamedtaskmngr.data.MyTurn;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Manager extends AppCompatActivity {
    private EditText etFirstName,etLastName,etPhone;
    private Button btnSave0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);
        etFirstName=findViewById(R.id.etFirstName);
        etLastName=findViewById(R.id.etLastName);
        etPhone=findViewById(R.id.etPhone);
        btnSave0=findViewById(R.id.btnSave0);

        btnSave0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler1();
            }
        });


    }
    private void dataHandler1() {
        String firstname = etFirstName.getText().toString();
        String Lastname = etLastName.getText().toString();
        String phone = etPhone.getText().toString();

        boolean isok1 = true;
        if (firstname.length() == 0) {
            etFirstName.setError("Enter Name");
            isok1 = false;

        }
        if (isok1) {

            MyManager M = new MyManager();
            M.setFname1(firstname);
            M.setLname1(Lastname);
            M.setPhone1(phone);
            creatMyManager(M);
        }

    }





    private void creatMyManager(MyManager M) {                                    //save in data base ******important
            //1.building object in data base
            FirebaseDatabase database=FirebaseDatabase.getInstance();
            FirebaseAuth auth= FirebaseAuth.getInstance();  //to get user uid  //1
            String uid = auth.getCurrentUser().getUid();
            M.setOwner(uid);
            //2.

            DatabaseReference reference = database.getReference();
            String key = reference.child("tasks").push().getKey();
            M.setKey(key);
            reference.child("tasks").child(uid).child(key).setValue(M).addOnCompleteListener(Manager.this, new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(Manager.this, "add successful", Toast.LENGTH_SHORT).show();
                        finish();

                    }
                    else {
                        Toast.makeText(Manager.this, "add failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        task.getException().printStackTrace();


                    }
                }
            });          ///
    }
}

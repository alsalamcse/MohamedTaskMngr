package com.example.mohamedtaskmngr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mohamedtaskmngr.data.MyTurn;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addTask extends AppCompatActivity {
    private EditText etTitle;
    private EditText etSubject;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        etTitle = findViewById(R.id.etTitle);
        etSubject = findViewById(R.id.etSubject);
        btnSave = findViewById(R.id.btnSave0);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });

    }

    private void dataHandler() {
        String tittle = etTitle.getText().toString();
        String subject = etSubject.getText().toString();;
        boolean isok = true;
        if (tittle.length()==0) {
            etTitle.setError("enter tittle");
            isok = false;
        }
        if (subject.length()==0) {
            etSubject.setError("enter subject");
            isok = false;

        }
        MyTurn t=new MyTurn();
        t.setSubject(subject);
        t.setTitle(tittle);
        creatMyTaskk(t);
    }

    private void creatMyTaskk(MyTurn t) {                                    //save in data base ******important
       //1.building object in data base
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        FirebaseAuth auth= FirebaseAuth.getInstance();  //to get user uid  //1
        String uid = auth.getCurrentUser().getUid();
        t.setOwner(uid);
        //2.

        DatabaseReference reference = database.getReference();
        String key = reference.child("tasks").push().getKey();
        t.setKey(key);
        reference.child("tasks").child(uid).child(key).setValue(t).addOnCompleteListener(addTask.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(addTask.this, "add successful", Toast.LENGTH_SHORT).show();
                    finish();

                }
               else {
                    Toast.makeText(addTask.this, "add failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();


                }
            }
        });          ////bena2 awla

    }
}
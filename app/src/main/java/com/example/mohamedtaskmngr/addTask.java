package com.example.mohamedtaskmngr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.example.mohamedtaskmngr.data.MyTask;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addTask extends AppCompatActivity {
    private EditText etTitle;
    private EditText etSubject;
    private EditText etPriority;
    private SeekBar sb;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        etTitle = findViewById(R.id.etTitle);
        etSubject = findViewById(R.id.etSubject);
        etPriority = findViewById(R.id.etPriority);
        sb = findViewById(R.id.sb);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });

    }

    private void dataHandler() {
        String tittle = etTitle.getText().toString();
        String subject = etSubject.getText().toString();
        int seekbar = sb.getProgress();
        boolean isok = true;
        if (tittle.length()==0) {
            etTitle.setError("enter tittle");
            isok = false;
        }
        if (subject.length()==0) {
            etSubject.setError("enter subject");
            isok = false;

        }
        MyTask t=new MyTask();
        t.setSubject(subject);
        t.setTitle(tittle);
        creatMyTaskk(t);
    }

    private void creatMyTaskk(MyTask t) {                                    //save in data base ******important
       //1.building object in data base
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        //2.
        DatabaseReference reference = database.getReference();
        String key = reference.child("tasks").push().getKey();
        reference.child("tasks").child(key).setValue(t);            ////bena2 awla

    }
}
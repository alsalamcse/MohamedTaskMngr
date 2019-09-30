package com.example.mohamedtaskmngr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

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
    }
}
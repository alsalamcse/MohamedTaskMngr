package com.example.mohamedtaskmngr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.ToggleButton;

public class Settings extends AppCompatActivity {
    private CheckBox cb;
    private EditText etSound;
    private ToggleButton tb;
    private EditText etFrontSize;
    private SeekBar sb;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        cb=findViewById(R.id.cb);
        etSound=findViewById(R.id.etSound);
        tb=findViewById(R.id.tb);
        etFrontSize=findViewById(R.id.etFrontSize);
        sb=findViewById(R.id.sb);
        btnSave=findViewById(R.id.btnSave);
    }
}

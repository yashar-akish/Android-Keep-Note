package com.company.keepnote;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener {

    EditText titleET, descriptionET;
    Button saveBTN, cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Add Note");
        setContentView(R.layout.activity_add_note);

        titleET = findViewById(R.id.titleET);
        descriptionET = findViewById(R.id.descriptionET);
        saveBTN = findViewById(R.id.saveBTN);
        cancelBtn = findViewById(R.id.cancelBTN);

        saveBTN.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.saveBTN) {
            saveNote();
        } else if (v.getId() == R.id.cancelBTN) {
            Toast.makeText(AddNoteActivity.this,"Nothing Saved", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void saveNote() {
        String noteTitle = titleET.getText().toString();
        String noteDescription = descriptionET.getText().toString();


    }
}
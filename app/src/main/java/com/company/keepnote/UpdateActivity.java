package com.company.keepnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener{

    EditText titleET, descriptionET;
    Button saveBTN, cancelBtn;
    int noteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Update Note");
        setContentView(R.layout.activity_update);

        titleET = findViewById(R.id.titleUpdateET);
        descriptionET = findViewById(R.id.descriptionUpdateET);
        saveBTN = findViewById(R.id.saveUpdateBTN);
        cancelBtn = findViewById(R.id.cancelUpdateBTN);

        saveBTN.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);

        getData();

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.saveUpdateBTN) {
            UpdateNote();
        } else if (v.getId() == R.id.cancelUpdateBTN) {
            Toast.makeText(UpdateActivity.this,"Nothing Updated", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    public void UpdateNote(){
        String titleLast = titleET.getText().toString();
        String descriptionLast = descriptionET.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("titleLast", titleLast);
        intent.putExtra("descriptionLast", descriptionLast);

        if (noteId != -1){
            intent.putExtra("noteId",noteId);
            setResult(RESULT_OK,intent);
            finish();
        }
    }

    public void getData(){
        Intent i = getIntent();
        noteId = i.getIntExtra("id", -1);
        String noteTitle = i.getStringExtra("title");
        String noteDescription = i.getStringExtra("description");

        titleET.setText(noteTitle);
        descriptionET.setText(noteDescription);
    }
}
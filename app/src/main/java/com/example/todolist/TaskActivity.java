package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TaskActivity extends AppCompatActivity {

    private TextView tvTaskTitle, tvTaskDescription, btnEdit;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        btnBack = findViewById(R.id.btnBack);
        tvTaskTitle = findViewById(R.id.tvTaskTitle);
        tvTaskDescription = findViewById(R.id.tvTaskDescription);
        btnEdit = findViewById(R.id.btnEdit);


        Intent i = getIntent();

        String task_title = i.getStringExtra("task_title");
        String task_description = i.getStringExtra("task_description");
        String task_date = i.getStringExtra("task_date");

        tvTaskTitle.setText(task_title);
        tvTaskDescription.setText(task_description);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
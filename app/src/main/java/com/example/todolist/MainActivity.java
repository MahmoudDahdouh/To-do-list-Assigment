package com.example.todolist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.adapter.TaskListAdapter;
import com.example.todolist.data.TaskList;
import com.example.todolist.register.LoginActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity_";

    private TextView tvLogout;
    private FirebaseAuth auth;
    private FirebaseFirestore database;

    private Button btnCreateNewList;

    private EditText edSearch;

    private TaskListAdapter adapter;
    private RecyclerView rvTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreateNewList = findViewById(R.id.btnCreateNewList);
        edSearch = findViewById(R.id.edSearch);
        tvLogout = findViewById(R.id.tvLogout);
        rvTasks = findViewById(R.id.rvTasks);

        auth = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
        setupRecycler();

        // load list
        loadList(auth.getCurrentUser().getUid());


        edSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SearchActivity.class));
            }
        });

        btnCreateNewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NewListActivity.class));

            }
        });


        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private void setupRecycler() {
        adapter = new TaskListAdapter();
        rvTasks.setAdapter(adapter);

        adapter.setOnItemClickListener(new TaskListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String title) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        });
    }

    private void loadList(String uid) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading ...");
        progressDialog.show();


        database.collection("task")
                .whereEqualTo("uid", uid)
                .get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        Log.d(TAG, "onSuccess: get all the list");
                        Log.d(TAG, "onSuccess: " + queryDocumentSnapshots.toObjects(TaskList.class).size());

                        List<TaskList> list = queryDocumentSnapshots.toObjects(TaskList.class);
                        adapter.setList(list);

                        progressDialog.dismiss();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(TAG, "onFailure: " + e.getMessage());
                        progressDialog.dismiss();

                    }
                });

    }
}
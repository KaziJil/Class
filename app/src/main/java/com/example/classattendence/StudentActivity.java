package com.example.classattendence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class StudentActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    StudentAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<AddStudentClass>addStudentClasses=new ArrayList<>();
    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        floatingActionButton=findViewById(R.id.student_activity_action_button);
        recyclerView=findViewById(R.id.student_activity_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new StudentAdapter(addStudentClasses,this);
        recyclerView.setAdapter(adapter);
        floatingActionButton.setOnClickListener(v -> studentShowDialog());



    }

    private void studentShowDialog() {
        Mydialog mydialog=new Mydialog();
        mydialog.show(getSupportFragmentManager(),Mydialog.STUDENT_ADD_DIALOG);
        mydialog.setListener((roll,name)->AddStudet(roll,name));
    }

    private void AddStudet(String roll, String name) {
        addStudentClasses.add(new AddStudentClass(roll,name));
        adapter.notifyDataSetChanged();
    }


}
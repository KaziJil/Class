package com.example.classattendence;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FloatingActionButton fab;
    MyAdapter adapter;
    ArrayList<ClassItem>classItems=new ArrayList<>();
    private TextView ClassName,SubjectName;
    private Button addBtn,cancelBtn;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    EditText classEdt,subjectEdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar();
        fab=findViewById(R.id.actin_button);
        fab.setOnClickListener(v-> showDialog());
        recyclerView=findViewById(R.id.recyclerView_main_page);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MyAdapter(classItems,this);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(position -> gotoAcitivity(position));


    }

    private void gotoAcitivity(int position) {
        Intent intent=new Intent(this,StudentActivity.class);
        intent.putExtra("ClassName",classItems.get(position).getClassName());
        intent.putExtra("subjectName",classItems.get(position).getSubjectName());
        intent.putExtra("position",position);
        startActivity(intent);

    }

    private void showDialog() {
        Mydialog mydialog=new Mydialog();
        mydialog.show(getSupportFragmentManager(),Mydialog.CLASS_ADD_DIALOG);
        mydialog.setListener((ClassName,SubjectName)->AddClass(ClassName,SubjectName));


    }

    private void AddClass(String ClassName,String SubjectName) {
        classItems.add(new ClassItem(ClassName,SubjectName));

        adapter.notifyDataSetChanged();
    }


    private void toolbar() {
        Toolbar toolbar=findViewById(R.id.toolbar_main);
        TextView title=toolbar.findViewById(R.id.title_text_toolbar);
        TextView subtitle=toolbar.findViewById(R.id.subtitle_text_toolbar);
        ImageButton save=toolbar.findViewById(R.id.save_ImageButton_toolLayout);
        ImageButton back=toolbar.findViewById(R.id.back_ImageButton_toolLayout);
        title.setText("Attendence App");
        subtitle.setVisibility(View.GONE);
        save.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
    }



}
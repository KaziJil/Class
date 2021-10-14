package com.example.classattendence;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    ArrayList<AddStudentClass>addStudentClasses;
    Context context;
    public StudentAdapter(ArrayList<AddStudentClass> addStudentClasses, Context context) {
        this.addStudentClasses = addStudentClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.student_layout,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.roll.setText(addStudentClasses.get(position).getRoll());
        holder.name.setText(addStudentClasses.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return addStudentClasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView roll,name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            roll=itemView.findViewById(R.id.student_roll);
            name=itemView.findViewById(R.id.student_name);
        }
    }
}

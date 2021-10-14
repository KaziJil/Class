package com.example.classattendence;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class Mydialog extends DialogFragment {
    EditText classEdt,subjectEdt;
    Button addBtn,cancelBtn;
    public static final String CLASS_ADD_DIALOG="addClass";
    public static final String STUDENT_ADD_DIALOG="addStudent";

    onClickListener listener;
    public interface onClickListener{
        void onClick(String text1,String text2);
    }
    public void setListener(onClickListener listener){
        this.listener=listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog=null;
        if (getTag().equals(CLASS_ADD_DIALOG))dialog=getAddClassDialog();
        if (getTag().equals(STUDENT_ADD_DIALOG))dialog=geStudentAddDialog();
        return dialog;
    }

    private Dialog geStudentAddDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        View view= LayoutInflater.from(getActivity()).inflate(R.layout.dialog,null);
        builder.setView(view);
        TextView title=view.findViewById(R.id.dialog_title_text);
        title.setText("Add New Student");
        classEdt=view.findViewById(R.id.et01);
        subjectEdt=view.findViewById(R.id.et02);
        classEdt.setHint("Student Roll");
        subjectEdt.setHint("Student Name");
        addBtn=view.findViewById(R.id.button_add);
        cancelBtn=view.findViewById(R.id.button_cancel);
        cancelBtn.setOnClickListener(v->dismiss());
        addBtn.setOnClickListener(v -> {
            String Roll=classEdt.getText().toString();
            String Name=subjectEdt.getText().toString();
            classEdt.setText(String.valueOf(Integer.parseInt(Roll)+1));
            subjectEdt.setText("");
            listener.onClick(Roll,Name);
        });
        return builder.create();

    }

    private Dialog getAddClassDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        View view= LayoutInflater.from(getActivity()).inflate(R.layout.dialog,null);
        builder.setView(view);
        TextView title=view.findViewById(R.id.dialog_title_text);
        title.setText("Add Class");
        classEdt=view.findViewById(R.id.et01);
        subjectEdt=view.findViewById(R.id.et02);
        classEdt.setHint("Add Class");
        subjectEdt.setHint("Add Subject");
        addBtn=view.findViewById(R.id.button_add);
        cancelBtn=view.findViewById(R.id.button_cancel);
        cancelBtn.setOnClickListener(v->dismiss());
        addBtn.setOnClickListener(v -> {
            String className=classEdt.getText().toString();
            String subjectName=subjectEdt.getText().toString();
            listener.onClick(className,subjectName);
            dismiss();
        });
        return builder.create();
    }
}

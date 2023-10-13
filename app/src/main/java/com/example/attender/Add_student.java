package com.example.attender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Add_student extends AppCompatActivity {
    Button addStudentButton;
    Button logoutButton;
    Button takeAttendanceButton;
    Button View_attendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        addStudentButton=findViewById(R.id.addStudentButton);
        logoutButton=findViewById(R.id.logoutButton);
        takeAttendanceButton =findViewById(R.id.takeAttendanceButton);
        View_attendance=findViewById(R.id.view_attendance);
        View_attendance.setOnClickListener(v -> {
            Intent intent =new Intent(Add_student.this, View_activity.class);
            startActivity(intent);
        });


        logoutButton.setOnClickListener(v -> {
            Intent intent=new Intent(Add_student.this,MainActivity.class);
            startActivity(intent);
        });
        addStudentButton.setOnClickListener(v -> {
            Intent intent=new Intent(Add_student.this,add_student1.class);
            startActivity(intent);

        });
        takeAttendanceButton.setOnClickListener(v -> {
            Intent intent =new Intent(Add_student.this,Select_class.class);
            startActivity( intent);
        });
    }
}
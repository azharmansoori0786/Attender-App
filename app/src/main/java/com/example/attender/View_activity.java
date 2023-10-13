package com.example.attender;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class View_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        setContentView(R.layout.activity_select_class);
        Spinner spinner1 =findViewById(R.id.class_spinner);
        Spinner spinner2 =findViewById(R.id.course_spinner);
        Spinner spinner3 =findViewById(R.id.year_spinner);
        String value1 []={"BBA","BCA","B.TECH","MBA"};
        ArrayList<String> v1=new ArrayList<>(Arrays.asList(value1));
        ArrayAdapter<String> arrayadapter=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,v1);
        spinner1.setAdapter(arrayadapter);
        String value2 []={"A","B","C","DEFAULT"};
        ArrayList<String> v2=new ArrayList<>(Arrays.asList(value2));
        ArrayAdapter<String> arrayadapter1=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,v2);
        spinner2.setAdapter(arrayadapter1);
        String value3[]={"IST","2ND","3RD","4TH"};
        ArrayList<String> v3=new ArrayList<>(Arrays.asList(value3));
        ArrayAdapter<String> arrayadapter2=new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,v3);
        spinner3.setAdapter(arrayadapter2);



}
}
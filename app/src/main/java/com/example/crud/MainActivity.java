package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button add , view , update , delete;
    EditText name,roll_no;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = findViewById(R.id.btnAdd);
        view = findViewById(R.id.btnView);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        name = findViewById(R.id.stName);
        roll_no = findViewById(R.id.stRoll);
        lst = findViewById(R.id.lst1);

        add.setOnClickListener(new View.OnClickListener() {
            StudentModel studentModel;

            @Override
            public void onClick(View view) {
                if(name.getText().toString()!="name" && roll_no.getText().toString() != "rollNo"){
                    try {
                        studentModel = new StudentModel(name.getText().toString(), Integer.parseInt(roll_no.getText().toString()));
                        //Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                    }
                    catch (Exception e){
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                    DBHelper dbHelper  = new DBHelper(MainActivity.this);
                    dbHelper.addStudent(studentModel);
                }

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                dbHelper.update(name.getText().toString(),roll_no.getText().toString());

            }
        });

        delete.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                dbHelper.delete(name.getText().toString(),roll_no.getText().toString());
            }
        }));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lst.setVisibility(View.VISIBLE);
                DBHelper dbHelper = new DBHelper(MainActivity.this);
                ArrayList<StudentModel> list = dbHelper.getAllStudents();
                ArrayAdapter arrayAdapter = new ArrayAdapter<StudentModel>
                        (MainActivity.this, android.R.layout.simple_list_item_1,list);
                lst.setAdapter(arrayAdapter);
            }
        });
    }
}
package com.example.myfirebaseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class editprofile extends AppCompatActivity {
    EditText email, name, number, house;
    Button snd;
    long max_num;
    Student std;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    Student stud;
    String numb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        std = new Student();

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference();
        //Intent intent = getIntent();
        numb = getIntent().getStringExtra("num");
        //button
        snd = (Button) findViewById(R.id.button);
        //text boxes
        email = (EditText) findViewById(R.id.editText);
        name = (EditText) findViewById(R.id.editText2);
        number = (EditText) findViewById(R.id.editText3);
        house = (EditText) findViewById(R.id.editText4);
        number.setText(numb);
        //database references
        mRef = mDatabase.getReference(numb);

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                stud = dataSnapshot.getValue(Student.class);
                name.setText(stud.getName());
                number.setText(stud.getPhone());
                house.setText(stud.getHouse());
                email.setText(stud.getEmail());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void update(View v){
        //update
        Map<String, Object> map = new HashMap<>();
        map.put("name", name.getText().toString());
        map.put("email", email.getText().toString());
        map.put("phone", number.getText().toString());
        map.put("house", house.getText().toString());
        mRef.updateChildren(map);


    }



}

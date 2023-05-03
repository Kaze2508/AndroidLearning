package com.example.myfirebaseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class createprofile extends AppCompatActivity {
    EditText email, name, number, house;
    Button snd;
    long max_num;
    Student std;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofile);
        std = new Student();
        mDatabase = FirebaseDatabase.getInstance();
        //button
        snd = (Button) findViewById(R.id.button);
        //text boxes
        email = (EditText) findViewById(R.id.editText);
        name = (EditText) findViewById(R.id.editText2);
        number = (EditText) findViewById(R.id.editText3);
        house = (EditText) findViewById(R.id.editText4);
        //database references
        mRef = mDatabase.getReference();
        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    max_num = (dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

    public void sendd(View v){
        //insert data
        std.setEmail(email.getText().toString());
        std.setName(name.getText().toString());
        std.setHouse(house.getText().toString());
        std.setPhone(number.getText().toString());
        mRef.child(String.valueOf(number.getText())).setValue(std);


    }
}


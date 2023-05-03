package com.example.myfirebaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class delete_profile extends AppCompatActivity {
    EditText number;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_profile);
        number = (EditText) findViewById(R.id.editText);
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference();

    }
    public void del(View v){
        mRef.child(String.valueOf(number.getText())).removeValue();
    }

}

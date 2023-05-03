package com.example.myfirebaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class before_edit extends AppCompatActivity {
    EditText number;
    String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_edit);
        number = (EditText) findViewById(R.id.editText);

    }
    public void proceed(View v){

        Intent gotoedit = new Intent();
        gotoedit.setClass(this, editprofile.class);
        gotoedit.putExtra("num", number.getText().toString());
        startActivity(gotoedit);

    }
}

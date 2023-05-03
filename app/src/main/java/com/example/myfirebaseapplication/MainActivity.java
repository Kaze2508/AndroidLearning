package com.example.myfirebaseapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button create_profile, dlt_profile, edit_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void create(View v){
        Intent gotocreate = new Intent();
        gotocreate.setClass(this, createprofile.class);
        startActivity(gotocreate);

    }
    public void update(View v){
        Intent gotoedit = new Intent();
        gotoedit.setClass(this, before_edit.class);
        startActivity(gotoedit);

    }
    public void delete(View v){
        Intent gotodel = new Intent();
        gotodel.setClass(this, delete_profile.class);
        startActivity(gotodel);

    }
    public void query(View v){
        Intent gotoquer = new Intent();
        gotoquer.setClass(this, query.class);
        startActivity(gotoquer);

    }
}

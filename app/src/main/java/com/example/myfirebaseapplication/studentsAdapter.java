package com.example.myfirebaseapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class studentsAdapter extends RecyclerView.Adapter<studentsAdapter.StudentViewHolder> {

    private Context mCtx;
    private List<Student> stList;

    public studentsAdapter(Context mCtx, List<Student> stList) {
        this.mCtx = mCtx;
        this.stList = stList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_students, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = stList.get(position);
        holder.textViewName.setText(student.getName());


    }

    @Override
    public int getItemCount() {
        return stList.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName, textViewPhone, textViewEmail, textViewHouse;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);

        }
    }
}




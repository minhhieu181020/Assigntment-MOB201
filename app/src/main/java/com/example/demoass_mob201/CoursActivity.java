package com.example.demoass_mob201;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class CoursActivity extends AppCompatActivity {
private CoursDAO coursDAO;
private TextView tvText;
private RecyclerView rvCours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cours);
        tvText=findViewById(R.id.tvText);
    }

    public void ShowYourCours(View view) {
        Intent intent=new Intent(CoursActivity.this,YourCoursActivity.class);
        startActivity(intent);
    }

    public void Cours1(View view) {
         AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setView(R.layout.activity_cours1_detail);

         AlertDialog alertDialog1 = alertDialog.show();
    }

    public void AddCours1(View view) {
        coursDAO=new CoursDAO(CoursActivity.this);
        List<Cours> coursList=coursDAO.selectCours();
        CoursAdapter coursAdapter=new CoursAdapter(CoursActivity.this,coursList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((CoursActivity.this));
        rvCours.setLayoutManager(linearLayoutManager);
        rvCours.setAdapter(coursAdapter);

    }
}

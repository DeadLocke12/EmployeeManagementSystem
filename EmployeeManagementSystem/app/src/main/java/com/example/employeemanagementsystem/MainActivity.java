package com.example.employeemanagementsystem;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnLoadAdmin(View view) {
        Intent intent = new Intent(MainActivity.this,AdminAuth.class);
        startActivity(intent);
    }
    public void OnLoadUser(View view){
        Intent intent = new Intent(MainActivity.this,Emp_Auth.class);
        startActivity(intent);
    }
}
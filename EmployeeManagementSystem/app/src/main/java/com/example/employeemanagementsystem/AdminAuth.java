package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminAuth extends AppCompatActivity {
    EditText Id, Pass;
    String Admin_id="", Admin_pass="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_auth);
        Id= (EditText)findViewById(R.id.userId);
        Pass=(EditText)findViewById(R.id.userPass);
    }
    public void onAdminLogin(View view){
        Admin_id=Id.getText().toString();
        Admin_pass=Pass.getText().toString();
        if(Admin_id.equals("Admin01") && Admin_pass.equals("Pass123")){
            Intent intent = new Intent(AdminAuth.this, DasboardAdminSide.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
        }
    }
}
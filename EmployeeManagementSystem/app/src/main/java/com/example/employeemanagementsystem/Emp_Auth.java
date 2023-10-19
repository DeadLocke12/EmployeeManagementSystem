package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Emp_Auth extends AppCompatActivity {
    EditText Id, Pass;
    String Emp_id="", Emp_pass="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_auth);
        Id= (EditText)findViewById(R.id.EmployeeUserId);
        Pass=(EditText)findViewById(R.id.employeePassword);
    }
    public void onEmpLogin(View view){
        final DataHandler dataHandler = new DataHandler(getApplicationContext(),"employee",null,1);
        Emp_id= Id.getText().toString();
        Emp_pass = Pass.getText().toString();
        int login = dataHandler.AuthenticateEmp(Emp_id);
        if(login== 1 && Emp_pass.equals("pass123")){
            Intent intent = new Intent(Emp_Auth.this, EmpDashboard.class);
            intent.putExtra("emp_id", Emp_id);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Incorrect User ID or Password", Toast.LENGTH_SHORT).show();
        }
    }
}
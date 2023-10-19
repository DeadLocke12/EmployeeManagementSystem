package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EmployeeDetailsEmployeeSide extends AppCompatActivity {
    TextView t1,name,job,salary;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details_employee_side);
        Intent intent = getIntent();
        id = intent.getStringExtra("Employee_id");

        t1=(TextView) findViewById(R.id.T1EmpSide);
        name=(TextView) findViewById(R.id.NameEmpSide);
        job=(TextView) findViewById(R.id.JobRoleEmpSide);
        salary=(TextView) findViewById(R.id.SalaryEmpSide);

    }

    public void onDisplay(View view){
        final DataHandler dataHandler = new DataHandler(getApplicationContext(),"employee",null,1);
        String[] Emp_details = dataHandler.getEmpData(id);
        String T1="details of employee "+id;
        t1.setText(T1);
        name.setText(Emp_details[1]);
        job.setText(Emp_details[2]);
        salary.setText(Emp_details[3]);
    }
}
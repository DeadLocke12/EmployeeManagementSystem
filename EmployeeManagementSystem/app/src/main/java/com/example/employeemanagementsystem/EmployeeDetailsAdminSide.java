package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EmployeeDetailsAdminSide extends AppCompatActivity {
    EditText emp_id,name,job,salary,email,find_Emp,Delete_emp;
    Button add,displayAll,search,delete;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details_admin_side);
        emp_id=(EditText) findViewById(R.id.emp_id);
        name=(EditText) findViewById(R.id.name);
        job=(EditText) findViewById(R.id.job);
        salary=(EditText) findViewById(R.id.salary);
        email = (EditText) findViewById(R.id.email);
        find_Emp=(EditText) findViewById(R.id.SearchEmployeeIdAdminSide);
        Delete_emp=(EditText) findViewById(R.id.DeletedEmployeeIdAdminSide);


        add=(Button)findViewById(R.id.register);
        displayAll=(Button)findViewById(R.id.DisplayAllAdminSide);
        search=(Button)findViewById(R.id.SearchEmployeeAdminSide);
        delete=(Button)findViewById(R.id.DeleteEmployeeAdminSide);
        text=(TextView)findViewById(R.id.textView3);
        final DataHandler dataHandler= new DataHandler(getApplicationContext(),"employee",null,1);



        add.setOnClickListener(V -> {
            final String id = emp_id.getText().toString();
            final String Empname= name.getText().toString();
            final String job_role =job.getText().toString();
            final String emp_salary = salary.getText().toString();
            final String emp_email = email.getText().toString();
            dataHandler.addEmployeeInfo(id,Empname,job_role,emp_salary,emp_email);
        });

        displayAll.setOnClickListener(V -> {
            String result = dataHandler.getAllEmployeeInfo();
            text.setText(result);
        });

        search.setOnClickListener(V -> {
            String id = find_Emp.getText().toString();
            String result = dataHandler.getEmployeeData(id);
            text.setText(result);
        });

        delete.setOnClickListener(V -> {
            String id = Delete_emp.getText().toString();
            dataHandler.deleteEmployeeData(id);
            Toast.makeText(EmployeeDetailsAdminSide.this, "Employee Deleted", Toast.LENGTH_SHORT).show();
        });

    }
}
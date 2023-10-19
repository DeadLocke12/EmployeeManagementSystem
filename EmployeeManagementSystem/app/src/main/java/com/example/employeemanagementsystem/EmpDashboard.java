package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmpDashboard extends AppCompatActivity {
    Button btn_goToEmployeeDetails,btn_goToApplyForLeavePage,btn_goToPayrollCheckingPage;
    String EmployeeId="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emp_dashboard);
        btn_goToEmployeeDetails= findViewById(R.id.goToEmployeeDetails);
        btn_goToApplyForLeavePage=findViewById(R.id.goToApplyForLeavePage);
        btn_goToPayrollCheckingPage = findViewById(R.id.goToPayrollCheckingPage);

        Intent intent = getIntent();
        EmployeeId = intent.getStringExtra("emp_id");

        btn_goToEmployeeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmpDashboard.this,EmployeeDetailsEmployeeSide.class);
                intent.putExtra("Employee_id", EmployeeId);
                startActivity(intent);
            }
        });

        btn_goToPayrollCheckingPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmpDashboard.this,PayrollPendingEmployeeSide.class);
                intent.putExtra("Employee_id", EmployeeId);
                startActivity(intent);
            }
        });

        btn_goToApplyForLeavePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmpDashboard.this,LeaveManagementEmployeeSide.class);
                intent.putExtra("Employee_id", EmployeeId);
                startActivity(intent);
            }
        });
    }
}
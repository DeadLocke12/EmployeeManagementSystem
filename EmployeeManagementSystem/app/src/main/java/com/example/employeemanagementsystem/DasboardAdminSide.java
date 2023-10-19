package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DasboardAdminSide extends AppCompatActivity {
    Button btn_goToManageEmployee,btn_goToLeaveManagement,btn_goToPayrollPendingPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard_admin_side);
        btn_goToManageEmployee= findViewById(R.id.goToAddAndManageEmployeeDetailsAdminSide);
        btn_goToLeaveManagement= findViewById(R.id.goToLeaveManagementAdminSide);
        btn_goToPayrollPendingPage=findViewById(R.id.goToPayrollPendingPageAdminSide);
        btn_goToManageEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DasboardAdminSide.this,EmployeeDetailsAdminSide.class);
                startActivity(intent);
            }
        });

        btn_goToLeaveManagement.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DasboardAdminSide.this,LeaveManagementAdminSide.class);
                startActivity(intent);
            }
        });

        btn_goToPayrollPendingPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DasboardAdminSide.this,PayrollPendingAdminSide.class);
                startActivity(intent);
            }
        });

    }
}
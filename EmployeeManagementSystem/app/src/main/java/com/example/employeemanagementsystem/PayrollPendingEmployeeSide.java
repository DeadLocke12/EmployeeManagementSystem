package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PayrollPendingEmployeeSide extends AppCompatActivity {
    String EmployeeId;
    Button btn_checkIfPayrollCanBeSent;
    TextView isPayrollAvailable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payroll_pending_employee_side);
        Intent intent = getIntent();
        EmployeeId = intent.getStringExtra("Employee_id");
        btn_checkIfPayrollCanBeSent = findViewById(R.id.btn_checkIfPayrollCanBeSent);
        isPayrollAvailable = findViewById(R.id.isPayrollAvailable);
        final DataHandler dataHandler= new DataHandler(getApplicationContext(),"employee",null,1);

        btn_checkIfPayrollCanBeSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[][] payrollDataForGivenEmployee = dataHandler.getPayPenData(EmployeeId);
            }
        });


    }
}
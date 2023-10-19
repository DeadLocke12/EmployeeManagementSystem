package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Random;

public class LeaveManagementEmployeeSide extends AppCompatActivity {
    String EmployeeId,leaveDay,leaveMonth,leaveYear;
    int intLeaveDay,intLeaveMonth,intLeaveYear;
    Button btnSave;
    EditText etYear, etMonth, etDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_management_employee_side);
        Intent intent = getIntent();
        EmployeeId = intent.getStringExtra("Employee_id");
        etYear= findViewById(R.id.et_year);
        etMonth= findViewById(R.id.et_month);
        etDay= findViewById(R.id.et_day);
        btnSave = findViewById(R.id.button_apply_for_leave);
        final DataHandler dataHandler= new DataHandler(getApplicationContext(),"employee",null,1);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leaveDay=etDay.getText().toString();
                intLeaveDay=Integer.parseInt(leaveDay);

                leaveMonth=etMonth.getText().toString();
                intLeaveMonth=Integer.parseInt(leaveMonth);

                leaveYear=etYear.getText().toString();
                intLeaveYear=Integer.parseInt(leaveYear);


                dataHandler.addLeaveInfo(EmployeeId,intLeaveMonth,intLeaveYear,intLeaveDay,"pending");
            }
        });

    }
}
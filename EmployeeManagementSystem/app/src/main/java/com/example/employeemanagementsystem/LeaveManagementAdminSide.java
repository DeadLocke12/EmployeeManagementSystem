package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.employeemanagementsystem.DataHandler;
import com.example.employeemanagementsystem.R;


public class LeaveManagementAdminSide extends AppCompatActivity {

    Button DisplayAllEmployees, FindEmployeeLeaveDetails;
    EditText et_EmployeeIDValue;
    TextView tv_LeaveEmployeeInfo;


    private String leaveEmployeeId;
    private String leaveId;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_management_admin_side);
        et_EmployeeIDValue= findViewById(R.id.et_EmployeeIDValue);
        tv_LeaveEmployeeInfo= findViewById(R.id.tv_LeaveEmployeeInfo);
        DisplayAllEmployees = findViewById(R.id.btn_DisplayAllEmployees);
        FindEmployeeLeaveDetails= findViewById(R.id.btn_FindEmployeeLeaveDetails);
        final DataHandler dataHandler = new DataHandler(getApplicationContext(),"employee",null,1);

        DisplayAllEmployees.setOnClickListener(V -> {
            String result = dataHandler.getAllLeaveInfo();
            tv_LeaveEmployeeInfo.setText(result);
        });
        FindEmployeeLeaveDetails.setOnClickListener(V -> {
            String id = et_EmployeeIDValue.getText().toString();
            String result = dataHandler.getEmployeeLeaveData(id);
            tv_LeaveEmployeeInfo.setText(result);
        });

    }
}
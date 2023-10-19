package com.example.employeemanagementsystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PayrollHistoryPageAdminSide extends AppCompatActivity {
    Spinner spinnerEmployeeDetails;
    String employee_id_payroll_value,employee_year_payroll_value,employee_month_payroll_value,employee_hours_payroll_value;
    int employee_id_payroll_value_in_integer,employee_year_payroll_value_in_integer,employee_month_payroll_value_in_integer,employee_hours_payroll_value_in_integer;
    Button button_save_payroll;
    EditText et_year, et_month, et_hour;
    TextView tv_employee_info;
    RecyclerView rvPayroll;
    DataHandler dataHandler;
    ArrayList<String> payroll_id,payroll_year,payroll_month,payroll_hours;
    PayrollPendingAdapter payrollPendingAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payroll_history_page_admin_side);
        /* datahandler*/
        dataHandler = new DataHandler(getApplicationContext(),"employee",null,1);
        /* arraylist*/
        payroll_id= new ArrayList<>();
        payroll_year= new ArrayList<>();
        payroll_month= new ArrayList<>();
        payroll_hours= new ArrayList<>();
        /* spinner*/
        spinnerEmployeeDetails = findViewById(R.id.spinner_employee_history_side);
        /* recycler view*/
        rvPayroll = findViewById(R.id.rvPayroll_history_page);
        /* text View*/
        tv_employee_info= findViewById(R.id.tv_employee_info_details_payroll_history_page);

        button_save_payroll = findViewById(R.id.button_view_all_payroll_history_side);


        List<String> employeeIdValues = new ArrayList<>();
        employeeIdValues= dataHandler.getAllEmployeeIDValuesForSpinner();
        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,employeeIdValues);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEmployeeDetails.setAdapter(dataAdapter);
        spinnerEmployeeDetails.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("choose employee id")){

                }else{
                    String item = parent.getItemAtPosition(position).toString();
                    employee_id_payroll_value= item;
                    employee_id_payroll_value_in_integer = Integer.parseInt(employee_id_payroll_value);
                    String emp_personal_details = dataHandler.getEmployeeData(employee_id_payroll_value);
                    tv_employee_info.setText(emp_personal_details);
                    Toast.makeText(parent.getContext(), "Selected: "+item, Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button_save_payroll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emp_personal_details2 = dataHandler.getAllPayrollHistoryInfo();
                tv_employee_info.setText(emp_personal_details2);
            }
        });



        payrollPendingAdapter = new PayrollPendingAdapter(this,payroll_id,payroll_year,payroll_month,payroll_hours);
        rvPayroll.setAdapter(payrollPendingAdapter);
        rvPayroll.setLayoutManager(new LinearLayoutManager(this));
    }

//    void storeDataInArray(){
//        Cursor cursor = dataHandler.readAllPayrollPendingInfo();
//        if(cursor.getCount()==0){
//            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
//        }else{
//            while(cursor.moveToNext()){
//                payroll_id.add(cursor.getString(0));
//                payroll_year.add(cursor.getString(1));
//                payroll_month.add(cursor.getString(2));
//                payroll_hours.add(cursor.getString(3));
//            }
//        }
//    }


}
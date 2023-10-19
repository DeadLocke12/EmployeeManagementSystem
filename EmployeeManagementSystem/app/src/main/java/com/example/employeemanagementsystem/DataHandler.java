package com.example.employeemanagementsystem;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataHandler extends SQLiteOpenHelper{
    public DataHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context,name,factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      db.execSQL("create table employee_data(emp_id integer primary key , emp_name varchar(100), emp_job text,emp_salary integer,emp_email varchar(100))");
      db.execSQL("create table leave_data(leaveRegistrationId integer primary key autoincrement, emp_id integer ,month integer,year integer,day integer,approvalStatus varchar(10))");
      db.execSQL("create table payroll_history_info(emp_id integer,year integer,month integer,amount integer,description varchar(100))");
      db.execSQL("create table payroll_pending_info(emp_id integer, year integer, month integer, hour integer)");

    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists employee_data");
        db.execSQL("drop table if exists leave_data");
        db.execSQL("drop table if exists payroll_history_info");
        db.execSQL("drop table if exists payroll_pending_info");

        onCreate(db);
    }
    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public void addEmployeeInfo(String id, String name, String job, String salary,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("emp_id", id);
        values.put("emp_name", name);
        values.put("emp_job", job);
        values.put("emp_salary", salary);
        values.put("emp_email", email);
        db.insert("employee_data",null, values);
        db.close();

    }
    public void addLeaveInfo(String emp_id, int month, int year,int day,String approvalStatus)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("leaveRegistrationId", (Integer) null);
        values.put("emp_id", emp_id);
        values.put("month", month);
        values.put("year", year);
        values.put("day", day);
        values.put("approvalStatus", approvalStatus);
        db.insert("leave_data",null, values);
        db.close();
    }
    public void addPayrollHistoryInfo(String emp_id,int month, int year,int amount,String description )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("emp_id", emp_id);
        values.put("month", month);
        values.put("year", year);
        values.put("amount", amount);
        values.put("description", description);
        db.insert("payroll_history_info",null, values);
        db.close();
    }

    public void addPayrollPendingInfo(String emp_id, int year ,int month ,int hour)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("emp_id", emp_id);
        values.put("month", month);
        values.put("year", year);
        values.put("hour", hour);
        db.insert("payroll_pending_info",null, values);
        db.close();
    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public String getAllEmployeeInfo() {
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from employee_data",null);
        String result = "";
        while(cursor.moveToNext()){
            String id1 = cursor.getString(0);
            String name1 = cursor.getString(1);
            String job1 = cursor.getString(2);
            String salary1 = cursor.getString(3);
            String email1 = cursor.getString(4);

            result+= id1+":"+" "+name1+" "+job1+ " "+ salary1+"\n";
        }
        db.close();
        return result;
    }

    public String getAllLeaveInfo() {
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from leave_data",null);
        String result = "";
        while(cursor.moveToNext()){
            String leaveRegistrationId1 = cursor.getString(0);
            String id1 = cursor.getString(1);
            String month1 = cursor.getString(2);
            String year1 = cursor.getString(3);
            String day1 = cursor.getString(4);
            String approvalStatus1 = cursor.getString(5);
            result+= id1+":"+" "+leaveRegistrationId1+" "+month1+" "+year1+ " "+ day1+" "+approvalStatus1+"\n";
        }
        db.close();
        return result;
    }

    public String getAllPayrollHistoryInfo() {
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from payroll_history_info",null);
        String result = "";
        while(cursor.moveToNext()){
            String id1 = cursor.getString(0);
            String month1 = cursor.getString(1);
            String year1 = cursor.getString(2);
            String amount1 = cursor.getString(3);
            String description1 = cursor.getString(4);
            result+= id1+":"+" "+month1+" "+year1+ " "+ amount1+ " "+ description1+"\n";
        }
        db.close();
        return result;
    }

    public String getAllPayrollPendingInfo() {
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from payroll_pending_info",null);
        String result = "";
        while(cursor.moveToNext()){
            String id1 = cursor.getString(0);
            String month1 = cursor.getString(1);
            String year1 = cursor.getString(2);
            String hour1 = cursor.getString(3);
            result+= id1+":"+" "+month1+" "+year1+ " "+ hour1+"\n";
        }
        db.close();
        return result;
    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


    public String getEmployeeData(String id){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from employee_data where emp_id= ?",new String[]{id});
        String result = "";
        while(cursor.moveToNext()){
            String id1 = cursor.getString(0);
            String name1 = cursor.getString(1);
            String job1 = cursor.getString(2);
            String salary1 = cursor.getString(3);
            String email1 =  cursor.getString(4);
            result+= id1+":"+" "+name1+" "+job1+ " "+ salary1+"\n";
        }
        db.close();
        return result;
    }
    public String getEmployeeLeaveData(String id){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from leave_data where emp_id= ?",new String[]{id});
        String result = "";
        while(cursor.moveToNext()){
            String leaveRegistrationId1 = cursor.getString(0);
            String id1 = cursor.getString(1);
            String month1 = cursor.getString(2);
            String year1 = cursor.getString(3);
            String day1 = cursor.getString(4);
            String approvalStatus1 = cursor.getString(5);
            result+= id1+":"+" "+leaveRegistrationId1+" "+month1+" "+year1+ " "+ day1+" "+approvalStatus1+"\n";
        }
        db.close();
        return result;
    }

    public String getEmployeePayrolHistoryInfo(String id){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from payroll_history_info where emp_id= ?",new String[]{id});
        String result = "";
        while(cursor.moveToNext()){
            String id1 = cursor.getString(0);
            String month1 = cursor.getString(1);
            String year1 = cursor.getString(2);
            String amount1 = cursor.getString(3);
            String description1 = cursor.getString(4);
            result+= id1+":"+" "+month1+" "+year1+ " "+ amount1+ " "+ description1+"\n";
        }
        db.close();
        return result;
    }
    public String getEmployeePayrollPendingInfo(String id){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from payroll_pending_info where emp_id= ?",new String[]{id});
        String result = "";
        while(cursor.moveToNext()){
            String id1 = cursor.getString(0);
            String month1 = cursor.getString(1);
            String year1 = cursor.getString(2);
            String hour1 = cursor.getString(3);
            result+= id1+":"+" "+month1+" "+year1+ " "+ hour1+"\n";
        }
        db.close();
        return result;
    }
    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public List<String> getAllEmployeeIDValuesForSpinner() {
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select emp_id from employee_data",null);
        List<String>  result = new ArrayList<>();
        int i =0;
        result.add(i,"choose employee id");
        while(cursor.moveToNext()){

            String id1 = cursor.getString(0);
            i=i+1;
            result.add(i,id1);
        }
        db.close();
        return result;
    }

    public String getAllLeaveIDInfo() {
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from leave_data",null);
        String result = "";
        while(cursor.moveToNext()){
            String leaveRegistrationId1 = cursor.getString(0);
            String id1 = cursor.getString(1);
            String month1 = cursor.getString(2);
            String year1 = cursor.getString(3);
            String day1 = cursor.getString(4);
            String approvalStatus1 = cursor.getString(5);
            result+= id1+":"+" "+leaveRegistrationId1+" "+month1+" "+year1+ " "+ day1+" "+approvalStatus1+"\n";
        }
        db.close();
        return result;
    }

    Cursor readAllPayrollPendingInfo(){
        String query = "select * from payroll_pending_info";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db!=null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }



    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public void deleteEmployeeData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("employee_data","emp_id"+"=?", new String[]{id});
        db.close();
    }
    public void deleteEmployeePayrollPendingInfo(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("payroll_pending_info","emp_id"+"=?", new String[]{id});
        db.close();
    }

    /*----------------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public int AuthenticateEmp(String id){
        int count;
        String id1 = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from employee_data where emp_id= ?",new String[]{id});
        while(cursor.moveToNext()){
            id1=cursor.getString(0);
        }

        if(id1.equals(null)){
            count=0;
        }
        else {
            count = 1;
        }
        db.close();
        return count;
    }

    public String[] getEmpData(String id){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from employee_data where emp_id= ? ",new String[]{id});
        String[] result = new String[6];
        while(cursor.moveToNext()){
            String id2 = cursor.getString(0);
            String name2 = cursor.getString(1);
            String job2 = cursor.getString(2);
            String salary2 = cursor.getString(3);
            String email2 = cursor.getString(4);
            result[0]= id2;
            result[1]= name2;
            result[2]= job2;
            result[3]= salary2;
            result[3]= email2;
        }
        db.close();
        return result;
    }
    public String[][] getPayPenData(String id){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from employee_data where emp_id= ? ",new String[]{id});
        String[][] result = new String[6][996];
        int i = 0;
        while(cursor.moveToNext()){
            String id2 = cursor.getString(0);
            String year2 = cursor.getString(1);
            String month2 = cursor.getString(2);
            String amount2 = cursor.getString(3);
            String description2 = cursor.getString(4);
            result[0][i]= id2;
            result[1][i]= year2;
            result[2][i]= month2;
            result[3][i]= amount2;
            result[4][i]= description2;
            i=i+1;
        }
        db.close();
        return result;
    }
}
/*  */
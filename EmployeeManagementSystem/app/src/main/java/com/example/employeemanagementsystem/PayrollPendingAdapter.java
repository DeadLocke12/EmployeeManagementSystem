package com.example.employeemanagementsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PayrollPendingAdapter extends RecyclerView.Adapter<PayrollPendingAdapter.MyViewHolder> {
    Context context;
    ArrayList hourly_report_id,
              hourly_report_year,
              hourly_report_month,
              hourly_report_hours;

    PayrollPendingAdapter(Context context,
                          ArrayList hourly_report_id,
                          ArrayList hourly_report_year,
                          ArrayList hourly_report_month,
                          ArrayList hourly_report_hours){

        this.context=context;
        this.hourly_report_id=hourly_report_id;
        this.hourly_report_year=hourly_report_year;
        this.hourly_report_month=hourly_report_month;
        this.hourly_report_hours=hourly_report_hours;

    }

    @NonNull
    @Override
    public PayrollPendingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.payroll_pending_employee_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PayrollPendingAdapter.MyViewHolder holder, int position) {
        holder.tv_hourly_report_id.setText(String.valueOf(hourly_report_id.get(position)));
        holder.tv_hourly_report_year.setText(String.valueOf(hourly_report_year.get(position)));
        holder.tv_hourly_report_month.setText(String.valueOf(hourly_report_month.get(position)));
        holder.tv_hourly_report_hours.setText(String.valueOf(hourly_report_hours.get(position)));

    }

    @Override
    public int getItemCount() {
        return hourly_report_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       TextView tv_hourly_report_id,
               tv_hourly_report_year,
               tv_hourly_report_month,
               tv_hourly_report_hours;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_hourly_report_id = itemView.findViewById(R.id.tv_hourly_report_id);
            tv_hourly_report_year = itemView.findViewById(R.id.tv_hourly_report_year);
            tv_hourly_report_month = itemView.findViewById(R.id.tv_hourly_report_month);
            tv_hourly_report_hours = itemView.findViewById(R.id.tv_hourly_report_hours);
        }
    }
}

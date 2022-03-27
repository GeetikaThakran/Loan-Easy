package com.geetika.loaneasy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geetika.loaneasy.R;

import java.util.List;

public class LenderListAdapter extends RecyclerView.Adapter<LenderListAdapter.ViewHolder>{
    private List<String> list_heading;
    private List<String> list_val;
    private List<String> risk;

    public LenderListAdapter(List<String> list_heading, List<String> list_val,List<String> risk) {
        this.list_heading = list_heading;
        this.list_val = list_val;
        this.risk = risk;
    }


    @NonNull
    @Override
    public LenderListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_lender, parent, false);
        return new LenderListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.applicationNo.setText("Application "+list_heading.get(position));
        holder.amt.setText(list_val.get(position));
        holder.risk.setText(risk.get(position));
    }

    @Override
    public int getItemCount() {
        return list_heading.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView applicationNo,amt,risk;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            applicationNo = itemView.findViewById(R.id.applicationName);
            amt = itemView.findViewById(R.id.lender_amt);
            risk = itemView.findViewById(R.id.risk);
        }
    }
}

package com.geetika.loaneasy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geetika.loaneasy.R;

import java.util.List;

public class CreditListAdapter extends RecyclerView.Adapter<CreditListAdapter.ViewHolder>{
    private List<String> list_heading;
    private List<String> list_val;

    public CreditListAdapter(List<String> list_heading, List<String> list_val) {
        this.list_heading = list_heading;
        this.list_val = list_val;
    }


    @NonNull
    @Override
    public CreditListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_horizontal, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditListAdapter.ViewHolder holder, int position) {
        holder.heading.setText(list_heading.get(position));
        holder.val.setText(list_val.get(position));
    }

    @Override
    public int getItemCount() {
        return list_heading.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading,val;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            val = itemView.findViewById(R.id.value);
        }
    }
}

package com.geetika.loaneasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.geetika.loaneasy.adapter.CreditListAdapter;
import com.geetika.loaneasy.adapter.LenderListAdapter;
import com.geetika.loaneasy.databinding.ActivityLenderDashboardBinding;
import com.geetika.loaneasy.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Objects;

public class LenderDashboardActivity extends AppCompatActivity {
    ArrayList<String> application_no;
    ArrayList<String> amt;
    ArrayList<String> risks;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    LenderListAdapter adapter;
    LinearLayoutManager layoutManager;

    ActivityLenderDashboardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLenderDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerViewLender.setLayoutManager(RecyclerViewLayoutManager);

        AddItemsToRecyclerViewArrayList();

        adapter = new LenderListAdapter(application_no,amt,risks);
        layoutManager = new LinearLayoutManager(LenderDashboardActivity.this,
                LinearLayoutManager.VERTICAL, false);
        binding.recyclerViewLender.setLayoutManager(layoutManager);
        binding.recyclerViewLender.setAdapter(adapter);
    }
    public void AddItemsToRecyclerViewArrayList()
    {
        // Adding items to ArrayList
        application_no = new ArrayList<>();
        application_no.add("Application 1 :");
        application_no.add("Application 2 :");
        application_no.add("Application 3 :");
        application_no.add("Application 4 :");

        amt = new ArrayList<>();
        amt.add("Amount : 250");
        amt.add("Amount : 250");
        amt.add("Amount : 250");
        amt.add("Amount : 250");

        risks = new ArrayList<>();
        risks.add("Credit Risk: 56");
        risks.add("Credit Risk: 56");
        risks.add("Credit Risk: 56");
        risks.add("Credit Risk: 56");
    }
}
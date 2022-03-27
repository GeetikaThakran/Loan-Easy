package com.geetika.loaneasy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.geetika.loaneasy.adapter.CreditListAdapter;
import com.geetika.loaneasy.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> headings;
    ArrayList<String> values;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    CreditListAdapter adapter;
    LinearLayoutManager HorizontalLayout;
    View ChildView;
    int RecyclerViewItemPosition;
    ActivityMainBinding binding;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();



        binding.btNav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerViewHorizontal.setLayoutManager(RecyclerViewLayoutManager);

        AddItemsToRecyclerViewArrayList();

        adapter = new CreditListAdapter(headings,values);
        HorizontalLayout = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerViewHorizontal.setLayoutManager(HorizontalLayout);
        binding.recyclerViewHorizontal.setAdapter(adapter);

        binding.cvApplyForLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),LoanApply.class);
                startActivity(i);
            }
        });

        binding.cvTrackStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),TrackStatus.class);
                startActivity(i);
            }
        });
        binding.cvRepayLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getApplicationContext(),RepayLoan.class);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void AddItemsToRecyclerViewArrayList()
    {
        // Adding items to ArrayList
        headings = new ArrayList<>();
        headings.add("Credit Score :");
        headings.add("Credit Limit :");

        values = new ArrayList<>();
        values.add("10");
        values.add("1000");
    }
}
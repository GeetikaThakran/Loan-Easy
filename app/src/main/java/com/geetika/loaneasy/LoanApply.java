package com.geetika.loaneasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoanApply extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_apply);

        Objects.requireNonNull(getSupportActionBar()).hide();

        ImageView back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        Button bt_next = findViewById(R.id.bt_next);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(LoanApply.this,LoanApplyProofsActivity.class);
                startActivity(i);
            }
        });


        // Spinner element
        Spinner spinner_state = (Spinner) findViewById(R.id.state_spinner);
        Spinner spinner_qualification = (Spinner) findViewById(R.id.qualification_spinner);
        Spinner spinner_loan_category = (Spinner) findViewById(R.id.loan_category_spinner);
        Spinner spinner_employment_sector= (Spinner) findViewById(R.id.employment_sector_spinner);
        Spinner spinner_business_type= (Spinner) findViewById(R.id.business_type_spinner);

        // Spinner click listener
        spinner_state.setOnItemSelectedListener(this);
        spinner_qualification.setOnItemSelectedListener(this);
        spinner_loan_category.setOnItemSelectedListener(this);
        spinner_employment_sector.setOnItemSelectedListener(this);
        spinner_business_type.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> states = new ArrayList<String>();
        List<String> qualifications = new ArrayList<String>();
        List<String> loan_category = new ArrayList<String>();
        List<String> employment_sector = new ArrayList<String>();
        List<String> business_type = new ArrayList<String>();

        states.add("Andhra Pradesh");
        states.add("Arunachal Pradesh");
        states.add("Assam");
        states.add("Bihar");
        states.add("Assam");
        states.add("Chhattisgarh");
        states.add("Goa");
        states.add("Gujarat");
        states.add("Haryana");
        states.add("Himachal Pradesh");
        states.add("Jharkhand");
        states.add("Karnataka");
        states.add("Kerala");
        states.add("Madhya Pradesh");
        states.add("Maharashtra");
        states.add("Manipur");
        states.add("Meghalaya");
        states.add("Mizoram");
        states.add("Nagaland");
        states.add("Odisha");
        states.add("Punjab");
        states.add("Rajasthan");
        states.add("Sikkim");
        states.add("Tamil Nadu");
        states.add("Telangana");
        states.add("Tripura");
        states.add("Uttar Pradesh");
        states.add("Uttarakhand");
        states.add("West Bengal");
        states.add("Delhi");
        states.add("Andaman and Nicobar");
        states.add("Chandigarh");
        states.add("Ladakh");
        states.add("Lakshadweep");
        states.add("Daman and Diu");
        states.add("Jammu and Kashmir");
        states.add("Dadar and Nagar Haveli");

        qualifications.add("Uneducated");
        qualifications.add("Primary Schooling");
        qualifications.add("Secondary Schooling");
        qualifications.add("Senior Secondary Schooling");
        qualifications.add("Diploma");
        qualifications.add("Undergraduation");
        qualifications.add("Post Graduation");

        loan_category.add("Education");
        loan_category.add("Health");
        loan_category.add("Business");
        loan_category.add("Others");

        employment_sector.add("Agriculture,forestry & fishing");
        employment_sector.add("Mining & quarrying");
        employment_sector.add("Manufacturing");
        employment_sector.add("Electricity, gas, water supply & other utility services");
        employment_sector.add("Construction");
        employment_sector.add("Trade, hotels, transport, communication and services related to broadcasting");
        employment_sector.add("Financial, real estate & prof servs");
        employment_sector.add("Public Administration, defence and other services");

        business_type.add("Auto Components");
        business_type.add("Automotive");
        business_type.add("Building Materials");
        business_type.add("Capital Goods");
        business_type.add("Chemicals");
        business_type.add("Construction");
        business_type.add("Consumers Durables");
        business_type.add("Diversified");
        business_type.add("FMCG-Non-Food");
        business_type.add("FMCG-Food");
        business_type.add("Forest Materials");
        business_type.add("Healthcare");
        business_type.add("Industrial Products");
        business_type.add("Information Technology");
        business_type.add("Media & Entertainment");
        business_type.add("Metals & Mining");
        business_type.add("Retail");
        business_type.add("Telecom");
        business_type.add("Textiles & Fashion");
        business_type.add("Tourism & Hospitality");
        business_type.add("Transportation & Logistics");
        business_type.add("Utilities");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter_state = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, states);
        ArrayAdapter<String> dataAdapter_qualification = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, qualifications);
        ArrayAdapter<String> dataAdapter_loan_category = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, loan_category);
        ArrayAdapter<String> dataAdapter_employment_sector = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, employment_sector);
        ArrayAdapter<String> dataAdapter_business_type = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, business_type);

        // Drop down layout style - list view with radio button
        dataAdapter_state.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter_qualification.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter_loan_category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter_employment_sector.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter_business_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner_state.setAdapter(dataAdapter_state);
        spinner_qualification.setAdapter(dataAdapter_qualification);
        spinner_loan_category.setAdapter(dataAdapter_loan_category);
        spinner_employment_sector.setAdapter(dataAdapter_employment_sector);
        spinner_business_type.setAdapter(dataAdapter_business_type);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
    }



    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
package com.geetika.loaneasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoanApplyProofsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int SELECT_PICTURE = 200;
    ImageView img_tv_bill;
    EditText loanAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_apply_proofs);

        Objects.requireNonNull(getSupportActionBar()).hide();

        ImageView back_button = findViewById(R.id.back_button2);
        TextView tv_upload_TV_Bill = findViewById(R.id.tv_upload_tvBill);
        img_tv_bill = findViewById(R.id.iv_tv_bill);
        Spinner spinner_loan_history = (Spinner) findViewById(R.id.loan_history_spinner);
        Spinner spinner_loan_type = (Spinner) findViewById(R.id.loan_type_spinner);
        Button submit =  findViewById(R.id.bt_submit);
        loanAmount = findViewById(R.id.et_loan_amount);
        int finalValue=0;
        try {
            String value= loanAmount.getText().toString();
            finalValue=Integer.parseInt(value);

            Log.v("aaa", String.valueOf(finalValue));
            Toast.makeText(getApplicationContext(),"amount :-"+finalValue,
                    Toast.LENGTH_SHORT).show();
        }catch (NumberFormatException e){

        }
        SharedPreferences sharedPreferences = getSharedPreferences("shared_preferences",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("loan_amt", loanAmount.getText().toString());
        myEdit.apply();



        int finalValue1 = finalValue;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(finalValue1 <1000){
                    Intent i = new Intent(getApplicationContext(),ProcessLoanApplicationActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(),"Please enter a Loan amount less then the credit limit amount.",
                            Toast.LENGTH_SHORT).show();

                    loanAmount.setError("Loan Amount cannot exceed the credit amount limit");
                }
            }
        });

        spinner_loan_history.setOnItemSelectedListener(this);
        spinner_loan_type.setOnItemSelectedListener(this);
        List<String> loanHistory = new ArrayList<String>();
        List<String> loanType = new ArrayList<String>();

        loanHistory.add("Loan not repaid on time");
        loanHistory.add("Loan taken and still repaying");
        loanHistory.add("Loan not taken/ repaid");

        loanType.add("Group Loan");
        loanType.add("Individual Loan");

        ArrayAdapter<String> dataAdapter_loanHistory = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, loanHistory);
        ArrayAdapter<String> dataAdapter_loanType = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, loanType);

        dataAdapter_loanHistory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapter_loanType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_loan_history.setAdapter(dataAdapter_loanHistory);
        spinner_loan_type.setAdapter(dataAdapter_loanType);





        tv_upload_TV_Bill.setPaintFlags(tv_upload_TV_Bill.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tv_upload_TV_Bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();
            }
        });
    }

    void imageChooser() {

        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);

        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }

    // this function is triggered when user
    // selects the image from the imageChooser
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    img_tv_bill.setImageURI(selectedImageUri);
                }
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
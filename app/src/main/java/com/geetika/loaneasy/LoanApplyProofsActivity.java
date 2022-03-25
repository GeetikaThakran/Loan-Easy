package com.geetika.loaneasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LoanApplyProofsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    int SELECT_PICTURE = 200;
    ImageView img_tv_bill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_apply_proofs);

        Objects.requireNonNull(getSupportActionBar()).hide();

        ImageView back_button = findViewById(R.id.back_button2);
        TextView tv_upload_TV_Bill = findViewById(R.id.tv_upload_tvBill);
        img_tv_bill = findViewById(R.id.iv_tv_bill);
        Spinner spinner_loan_history = (Spinner) findViewById(R.id.loan_history_spinner);

        spinner_loan_history.setOnItemSelectedListener(this);
        List<String> loanHistory = new ArrayList<String>();

        loanHistory.add("Loan not repaid on time");
        loanHistory.add("Loan taken and still repaying");
        loanHistory.add("Loan not taken/ repaid");

        ArrayAdapter<String> dataAdapter_loanHistory = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, loanHistory);

        dataAdapter_loanHistory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_loan_history.setAdapter(dataAdapter_loanHistory);





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
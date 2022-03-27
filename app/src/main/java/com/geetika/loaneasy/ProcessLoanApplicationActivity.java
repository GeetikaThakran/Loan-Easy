package com.geetika.loaneasy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class ProcessLoanApplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_loan_application);

        Objects.requireNonNull(getSupportActionBar()).hide();

        Button trackApplicationButton = findViewById(R.id.track_status_button);

        trackApplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TrackStatus.class);
                startActivity(i);
            }
        });
    }
}
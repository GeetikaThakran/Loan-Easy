package com.geetika.loaneasy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import com.geetika.loaneasy.databinding.ActivityLoginAsAdminOrBorrowerBinding;

import java.util.Objects;

public class LoginAsAdminOrBorrower extends AppCompatActivity {

    private ActivityLoginAsAdminOrBorrowerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginAsAdminOrBorrowerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();
        binding.cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog TempDialog;
                CountDownTimer CDT;
                final int[] i = {2};

                TempDialog = new ProgressDialog(LoginAsAdminOrBorrower.this);
                TempDialog.setMessage("Please wait...");
                TempDialog.setCancelable(false);
                TempDialog.setProgress(i[0]);
                TempDialog.show();

                CDT = new CountDownTimer(1500, 1000)
                {
                    public void onTick(long millisUntilFinished)
                    {
                        TempDialog.setMessage("Please wait..");
                        i[0]--;
                    }

                    public void onFinish()
                    {
                        TempDialog.dismiss();
                        //Your Code ...
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                }.start();

            }
        });

        binding.cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog TempDialog;
                CountDownTimer CDT;
                final int[] i = {2};

                TempDialog = new ProgressDialog(LoginAsAdminOrBorrower.this);
                TempDialog.setMessage("Please wait...");
                TempDialog.setCancelable(false);
                TempDialog.setProgress(i[0]);
                TempDialog.show();

                CDT = new CountDownTimer(1500, 1000)
                {
                    public void onTick(long millisUntilFinished)
                    {
                        TempDialog.setMessage("Please wait..");
                        i[0]--;
                    }

                    public void onFinish()
                    {
                        TempDialog.dismiss();
                        //Your Code ...
                        Intent intent = new Intent(getApplicationContext(),LenderDashboardActivity.class);
                        startActivity(intent);
                    }
                }.start();

            }
        });
    }
}
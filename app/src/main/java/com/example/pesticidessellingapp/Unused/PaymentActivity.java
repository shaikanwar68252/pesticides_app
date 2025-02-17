package com.example.pesticidessellingapp.Unused;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pesticidessellingapp.R;

public class PaymentActivity extends AppCompatActivity {

    private Button btnPhonePe, btnAmazonPay, btnGooglePay, btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_continuning);

        // Initialize buttons
        btnPhonePe = findViewById(R.id.btn_phonepe);
        btnContinue = findViewById(R.id.btn_continue);

        // PhonePe Click Listener
        btnPhonePe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymentActivity.this, "PhonePe Selected", Toast.LENGTH_SHORT).show();
            }
        });

        // Amazon Pay Click Listener
        btnAmazonPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymentActivity.this, "Amazon Pay Selected", Toast.LENGTH_SHORT).show();
            }
        });

        // Google Pay Click Listener
        btnGooglePay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymentActivity.this, "Google Pay Selected", Toast.LENGTH_SHORT).show();
            }
        });

        // Continue Button Click Listener
        //btnContinue.setOnClickListener(new View.OnClickListener() {
           // @Override
            //public void onClick(View v) {
                //Toast.makeText(PaymentActivity.this, "Proceeding to Payment", Toast.LENGTH_SHORT).show();
                // Navigate to the next activity (Example)
               // Intent intent = new Intent(PaymentActivity.this, OrderSummaryActivity.class);
               // startActivity(intent);
            //}
       // });
    }
}

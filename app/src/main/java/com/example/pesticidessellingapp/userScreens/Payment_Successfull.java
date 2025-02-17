package com.example.pesticidessellingapp.userScreens;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pesticidessellingapp.R;

public class Payment_Successfull extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_sucessfull);

        Button btnContinueShopping = findViewById(R.id.btn_continue_shopping);
        btnContinueShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        //        Intent intent = new Intent(PaymentSuccessActivity.this, MainActivity.class);
           //     startActivity(intent);
                finish();
            }
        });
    }

    public void setContentView(int activityPaymentSucessfull) {
    }
}

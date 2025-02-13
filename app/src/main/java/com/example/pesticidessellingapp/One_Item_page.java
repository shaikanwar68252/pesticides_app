package com.example.pesticidessellingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class One_Item_page extends AppCompatActivity {  // Corrected: no colon here

    private Button btn_add_to_cart, btn_buy_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_item_page);

        btn_add_to_cart = findViewById(R.id.btn_add_to_cart);
        btn_buy_now = findViewById(R.id.btn_buy_now);

        btn_add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(One_Item_page.this, "Added to Cart!", Toast.LENGTH_SHORT).show();
            }
        });

        //btn_buy_now.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View v) {
        //Intent intent = new Intent(One_Item_page.this, CheckoutActivity.class);
        // startActivity(intent);
        // }
        //});
    }
}

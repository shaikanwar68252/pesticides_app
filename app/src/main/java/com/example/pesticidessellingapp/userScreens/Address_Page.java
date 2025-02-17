package com.example.pesticidessellingapp.userScreens;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pesticidessellingapp.R;

public class Address_Page extends AppCompatActivity {

    private EditText etFullname, etMobile, etPincode, etState, etCity, etHouseNo, etRoad;
    private RadioGroup radioGroupAddressType;
    private Button btnSaveAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_page);

        etFullname = findViewById(R.id.et_fullname);
        etMobile = findViewById(R.id.et_mobile);
        etPincode = findViewById(R.id.et_pincode);
        etState = findViewById(R.id.et_state);
        etCity = findViewById(R.id.et_city);
        etHouseNo = findViewById(R.id.et_house_no);
        etRoad = findViewById(R.id.et_road);
        radioGroupAddressType = findViewById(R.id.radioGroup_address_type);
        btnSaveAddress = findViewById(R.id.btn_save_address);

        btnSaveAddress.setOnClickListener(v -> {
            String fullName = etFullname.getText().toString();
            Toast.makeText(this, "Address Saved: " + fullName, Toast.LENGTH_SHORT).show();
        });
    }
}

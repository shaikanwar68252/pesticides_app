package com.example.pesticidessellingapp.userScreens;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.cardview.widget.CardView;

import com.example.pesticidessellingapp.R;
import com.google.android.gms.maps.MapView;

public class Tractors_Details2 extends AppCompatActivity {

    private ImageView imageViewBack, imageViewShare, product1;
    private TextView textView22, textView3, textView43;
    private AppCompatButton shopNowBtn, verifyDocs, btnProceedRental;
    private CardView cardView1, cardView2, cardView3, cardView4;
    private TextView enginePowerText, fuelTypeText, capacityText, yearText;
    private TextView technicalDetailsText, featuresText, rentalTermsText, locationText, locationDistanceText, checkCalendarText;
    private LinearLayout technicalLayout, featuresLayout, rentalLayout;
    private MapView mapViewRent;
    private ScrollView mainScrollView;
    private Bundle mapViewBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tractors_details2);

        initializeViews();
        setupListeners();

        mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle("mapViewBundleKey");
        }

        mapViewRent.onCreate(mapViewBundle);
    }

    private void initializeViews() {
        mainScrollView = findViewById(R.id.main876862);
        imageViewBack = findViewById(R.id.imageViewback_rent);
        imageViewShare = findViewById(R.id.imageViewshare);
        product1 = findViewById(R.id.product1);
        textView22 = findViewById(R.id.textView22);
        textView3 = findViewById(R.id.textView3);
        textView43 = findViewById(R.id.textView43);
        shopNowBtn = findViewById(R.id.shopNowBtn);
        verifyDocs = findViewById(R.id.verify_docs);
        btnProceedRental = findViewById(R.id.btn_proceed_rental);

        cardView1 = findViewById(R.id.engine);
        cardView2 = findViewById(R.id.fuel);
        cardView3 = findViewById(R.id.capacity);
        cardView4 = findViewById(R.id.year);

        enginePowerText = findViewById(R.id.enginePowerText);
        fuelTypeText = findViewById(R.id.fuelTypeText);
        capacityText = findViewById(R.id.capacityText);
        yearText = findViewById(R.id.yearText);

        technicalLayout = findViewById(R.id.technical);
        featuresLayout = findViewById(R.id.features);
        rentalLayout = findViewById(R.id.rental);

        technicalDetailsText = findViewById(R.id.technicalDetailsText);
        featuresText = findViewById(R.id.featuresText);
        rentalTermsText = findViewById(R.id.rentalTermsText);

        locationText = findViewById(R.id.locationText);
        locationDistanceText = findViewById(R.id.locationDistanceText);
        checkCalendarText = findViewById(R.id.checkCalendarText);

        mapViewRent = findViewById(R.id.mapView_rent);
    }

    private void setupListeners() {
        imageViewBack.setOnClickListener(v -> onBackPressed());

        imageViewShare.setOnClickListener(v -> {
            // Handle share button click
        });

        shopNowBtn.setOnClickListener(v -> {
            // Handle shop now button click
        });

        verifyDocs.setOnClickListener(v -> {
            // Handle verify documents button click
        });

        btnProceedRental.setOnClickListener(v -> {
            // Handle rent now button click
        });

        technicalLayout.setOnClickListener(v -> {
            //Handle technical details layout click
        });

        featuresLayout.setOnClickListener(v -> {
            //Handle features layout click
        });

        rentalLayout.setOnClickListener(v -> {
            //Handle rental layout click
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapViewRent.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapViewRent.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapViewRent.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapViewRent.onLowMemory();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewSavedState = new Bundle();
        mapViewRent.onSaveInstanceState(mapViewSavedState);
        outState.putBundle("mapViewBundleKey", mapViewSavedState);
    }
}
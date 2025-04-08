package com.example.pesticidessellingapp.userScreens;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.pesticidessellingapp.Module.Properties;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.databinding.ActivityTractorsDetails2Binding;
import com.google.android.gms.maps.MapView;

public class Tractors_Details2 extends AppCompatActivity {

    private ActivityTractorsDetails2Binding binding;
    private Bundle mapViewBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTractorsDetails2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupListeners();
        loadPropertyData();

        mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle("mapViewBundleKey");
        }

        binding.mapViewRent.onCreate(mapViewBundle);
    }

    private void loadPropertyData() {
        Properties properties = getIntent().getParcelableExtra("item");
        if (properties != null) {
            binding.capacityText.setText(properties.getCapacity());
            binding.pro1Rent.setText(properties.getTitle());
            binding.modelRent.setText(properties.getModel());
            binding.enginePowerText.setText(properties.getEngine_power());
            binding.fuelTypeText.setText(properties.getFuel_type());
            binding.yearText.setText(properties.getYear());
            binding.technicalRental.setText(properties.getTechnical_details());
            binding.rentalMain.setText(properties.getRental_terms());
            binding.featuresRental.setText(properties.getFeatures());
            binding.priceRent.setText(properties.getRate_per_day());

            // ✅ Load image with Glide
            Glide.with(this)
                    .load(properties.getImage_path())
                    .placeholder(R.drawable.placeholder)
                    .into(binding.product1);
        }
    }

    private void setupListeners() {
        binding.backArrowPage1.setOnClickListener(v -> onBackPressed());

        binding.imageViewshare.setOnClickListener(v -> {
            // Handle share button click
        });

        binding.shopNowBtn.setOnClickListener(v -> {
            // Handle shop now button click
        });

        binding.verifyDocs.setOnClickListener(v -> {
            Intent intent = new Intent(Tractors_Details2.this, ActivityDocumentVerify.class);
            startActivity(intent);
        });

        binding.btnProceedRental.setOnClickListener(v -> {
            Intent intent = new Intent(Tractors_Details2.this, ProceedRent.class);
            startActivity(intent);
        });

        binding.technical.setOnClickListener(v -> {
            // Handle technical layout click
        });

        binding.features.setOnClickListener(v -> {
            // Handle features layout click
        });

        binding.rental.setOnClickListener(v -> {
            // Handle rental layout click
        });

        binding.product1.setOnClickListener(v -> {
            loadFragment(new UserProfileFragment());
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main, fragment); // make sure you have a container with id `main`
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        binding.mapViewRent.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        binding.mapViewRent.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.mapViewRent.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        binding.mapViewRent.onLowMemory();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Bundle mapViewSavedState = new Bundle();
        binding.mapViewRent.onSaveInstanceState(mapViewSavedState);
        outState.putBundle("mapViewBundleKey", mapViewSavedState);
    }
}

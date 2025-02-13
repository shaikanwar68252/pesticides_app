package com.example.pesticidessellingapp;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Bottom_Navigation extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        // Adjusting for system insets (optional for UI handling)
        View mainView = findViewById(R.id.container);
        ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
            WindowInsetsCompat systemBars = insets;
            int left = systemBars.getInsets(WindowInsetsCompat.Type.systemBars()).left;
            int top = systemBars.getInsets(WindowInsetsCompat.Type.systemBars()).top;
            int right = systemBars.getInsets(WindowInsetsCompat.Type.systemBars()).right;
            int bottom = systemBars.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
            v.setPadding(left, top, right, bottom);
            return insets;
        });

        bottomNavigationView = findViewById(R.id.bottomnavigation);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new Home_Fragment())
                    .commit();
        }
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            if (item.getItemId() == R.id.home) {
                selectedFragment = new Home_Fragment();
            } else if (item.getItemId() == R.id.Add_Rentals) {
                selectedFragment = new Addrental_Fragment();
            } else if (item.getItemId() == R.id.Person) {
                selectedFragment = new Profile_Fragment();
            }
            if (selectedFragment != null) {
                getSupportFragmentManager().popBackStack(null, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, selectedFragment)
                        .commit();
                return true;
            }
            return false;
        });
    }
}

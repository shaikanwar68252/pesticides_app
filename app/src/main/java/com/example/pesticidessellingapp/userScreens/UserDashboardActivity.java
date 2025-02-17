package com.example.pesticidessellingapp.userScreens;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.pesticidessellingapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserDashboardActivity extends AppCompatActivity {
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
                    .replace(R.id.container, new UserHomeFragment())
                    .commit();
        }
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            if (item.getItemId() == R.id.home) {
                selectedFragment = new UserHomeFragment();
            } else if (item.getItemId() == R.id.rentals) {
                selectedFragment = new UserRentalFragment();
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

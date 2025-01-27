package com.example.pesticidessellingapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pesticidessellingapp.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserDashboardDemo extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_dashboard_demo);

        bottomNavigationView = findViewById(R.id.bottomNav);
        frameLayout = findViewById(R.id.container);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new  HomeFragment()).commit();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                int itemId = menuItem.getItemId();


                if(itemId == R.id.home){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new  HomeFragment()).commit();
                }
                if (itemId == R.id.search){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new UserSearchFragment()).commit();
                }

                if (itemId == R.id.profile){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,new ProfileFragment()).commit();
                }


                return false;
            }
        });



    }
}
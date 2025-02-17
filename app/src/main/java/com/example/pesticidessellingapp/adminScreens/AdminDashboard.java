package com.example.pesticidessellingapp.adminScreens;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pesticidessellingapp.R;

import java.util.ArrayList;
import java.util.List;

public class AdminDashboard extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdminDashboardAdapter adapter;
    private List<AdminDashboardModel> buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        // Handling system insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Add button data
        buttonList = new ArrayList<>();
        buttonList.add(new AdminDashboardModel("Items"));
        buttonList.add(new AdminDashboardModel("Manage Accounts"));
        buttonList.add(new AdminDashboardModel("Requests"));
        buttonList.add(new AdminDashboardModel("Log Out"));

        adapter = new AdminDashboardAdapter(this, buttonList, position -> {
            switch (position) {
                case 0:
                    // Handle "Items" button click
                  //  startActivity(new Intent(Admin_Page.this, ItemsActivity.class));
                    break;
               case 1:
                    // Handle "Manage Accounts" button click
                   // startActivity(new Intent(Admin_Page.this, ManageAccountsActivity.class));
                    break;
                case 2:
                    // Handle "Update" button click
                 //   startActivity(new Intent(Admin_Page.this, UpdateActivity.class));
                    break;
                case 3:
                    // Handle "Log Out" button click
                    finish();
                    break;
            }
        });

        recyclerView.setAdapter(adapter);
    }
}

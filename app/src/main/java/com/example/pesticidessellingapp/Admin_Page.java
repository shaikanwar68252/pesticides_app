package com.example.pesticidessellingapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.List;

public class Admin_Page extends AppCompatActivity {
    private RecyclerView recyclerView;
    private adminpage_adapter adapter;
    private List<adminpage_model> buttonList;

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
        buttonList.add(new adminpage_model("Items"));
        buttonList.add(new adminpage_model("Manage Accounts"));
        buttonList.add(new adminpage_model("Requests"));
        buttonList.add(new adminpage_model("Log Out"));

        adapter = new adminpage_adapter(this, buttonList, position -> {
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

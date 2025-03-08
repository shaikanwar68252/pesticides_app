package com.example.pesticidessellingapp.CommonScreens;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pesticidessellingapp.Auth.LoginActivity;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.Unused.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class UserSelectionActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private userselection_adapter adapter;
    private List<userselection_model> buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_selection);

        // Handling system insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recyclerView6);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonList = new ArrayList<>();
        buttonList.add(new userselection_model("User Login"));
        buttonList.add(new userselection_model("Admin Login"));

        adapter = new userselection_adapter(this, buttonList, (int position) -> {
            if (position == 0) {
                startActivity(new Intent(UserSelectionActivity.this, ProductItem.UserLoginActivity.class));
            } else if (position == 1) {
                startActivity(new Intent(UserSelectionActivity.this, LoginActivity.class));
            }
        });

        recyclerView.setAdapter(adapter);
    }
}

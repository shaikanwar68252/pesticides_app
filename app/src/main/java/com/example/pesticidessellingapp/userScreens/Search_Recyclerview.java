package com.example.pesticidessellingapp.userScreens;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pesticidessellingapp.R;

import java.util.Arrays;
import java.util.List;  // Import List

public class Search_Recyclerview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recyclerview);

        // Sample job list
        List<Module_Search> jobList = Arrays.asList(
                new Module_Search("Agricultural Scientist", "California, USA", "$90k - $110k"),
                new Module_Search("Pesticide Sales Manager", "Texas, USA", "$80k - $100k"),
                new Module_Search("Field Agronomist", "Florida, USA", "$70k - $90k"),
                new Module_Search("Crop Consultant", "Iowa, USA", "$85k - $105k"),
                new Module_Search("Pesticide Researcher", "New York, USA", "$95k - $120k")
        );

        // Setup RecyclerView
        RecyclerView recyclerView = findViewById(R.id.jobRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Searchnew_Adapter(this, jobList));
    }
}

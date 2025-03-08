package com.example.pesticidessellingapp.CommonScreens;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pesticidessellingapp.R;
import java.util.Locale;

public class LanguageSelectionActivity extends AppCompatActivity {

    private CheckBox chkEnglish, chkHindi, chkTamil;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        chkEnglish = findViewById(R.id.chkEnglish);
        chkHindi = findViewById(R.id.chkHindi);
        chkTamil = findViewById(R.id.chkTamil);

        preferences = getSharedPreferences("Settings", MODE_PRIVATE);
        String currentLanguage = preferences.getString("My_Lang", "en"); // Default to English

        // Set checkboxes based on saved language
        updateCheckBoxes(currentLanguage);

        // Handle language selection
        chkEnglish.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) changeLanguage("en");
        });

        chkHindi.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) changeLanguage("hi");
        });

        chkTamil.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) changeLanguage("ta");
        });
    }

    private void changeLanguage(String langCode) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("My_Lang", langCode);
        editor.apply();

        // Apply new locale settings
        setLocale(langCode);

        // Restart the activity to apply the language
        Intent intent = new Intent(this, GetStartedActivity.class);
        startActivity(intent);
        finish();
    }

    private void setLocale(String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        Resources res = getResources();
        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(locale);
        res.updateConfiguration(config, res.getDisplayMetrics());
    }

    private void updateCheckBoxes(String lang) {
        chkEnglish.setChecked(lang.equals("en"));
        chkHindi.setChecked(lang.equals("hi"));
        chkTamil.setChecked(lang.equals("ta"));
    }
}


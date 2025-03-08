package com.example.pesticidessellingapp;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Locale;

public class BaseFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        loadLanguage();
        super.onCreate(savedInstanceState);
    }

    private void loadLanguage() {
        SharedPreferences prefs = requireActivity().getSharedPreferences("Settings", requireActivity().MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "en"); // Default to English
        setLocale(language);
    }

    private void setLocale(String langCode) {
        Locale locale = new Locale(langCode);
        Locale.setDefault(locale);
        Resources res = getResources();
        Configuration config = new Configuration(res.getConfiguration());
        config.setLocale(locale);
        res.updateConfiguration(config, res.getDisplayMetrics());
    }
}

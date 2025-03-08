package com.example.pesticidessellingapp.userScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pesticidessellingapp.CommonScreens.LanguageSelectionActivity;
import com.example.pesticidessellingapp.databinding.FragmentsUserProfileBinding;

public class UserProfileFragment extends Fragment {

    private FragmentsUserProfileBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Proper binding initialization
        binding = FragmentsUserProfileBinding.inflate(inflater, container, false);

        // Privacy Click Listener
        binding.privacy.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), Privacy_page.class));
        });

        // Help Click Listener
        binding.help.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), Help_Page.class));
        });

        // My Orders Click Listener
        binding.myorders.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), My_Orders.class));
        });

        // Edit Profile Click Listener
        binding.imageViewedit.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), Edit_Profile.class));
        });
        binding.settingsCV.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), LanguageSelectionActivity.class));
        });

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Avoid memory leaks
    }
}

package com.example.pesticidessellingapp.userScreens;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.databinding.FragmentAddRentalBinding;

public class AddRentalFragment extends Fragment {

    FragmentAddRentalBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAddRentalBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        defaultColors();


        return view;
    }

    private void defaultColors() {

//        binding.radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
//            if (checkedId == R.id.landRadio) {
//                binding.landRadio.setTextColor(Color.BLACK);
//                binding.tractorRadio.setTextColor(Color.GRAY);
//            }
//            if (checkedId == R.id.tractorRadio){
//
//            }
//        });
    }
}
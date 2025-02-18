package com.example.pesticidessellingapp.userScreens;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pesticidessellingapp.Auth.LoginActivity;
import com.example.pesticidessellingapp.R;

import java.io.IOException;

public class UserProfileFragment extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;

    private ImageView profileImage;
    private EditText etName, etCrop, etLand;
    private Button btnSelectImage, btnUpdateProfile, btnAddAddress, btnLogout;
    private Uri imageUri; // For storing selected image URI

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragments_user_profile, container, false);

        // Initialize UI elements
//        profileImage = view.findViewById(R.id.profile_image);
//        etName = view.findViewById(R.id.et_name);
//        etCrop = view.findViewById(R.id.et_crop);
//        etLand = view.findViewById(R.id.et_land);
//        btnSelectImage = view.findViewById(R.id.btn_select_image);
//        btnUpdateProfile = view.findViewById(R.id.btn_update_profile);
//        btnAddAddress = view.findViewById(R.id.Add_Address1);
//        btnLogout = view.findViewById(R.id.btn_logout);

//        // Set OnClickListener for buttons
//        btnSelectImage.setOnClickListener(clickListener);
//        btnUpdateProfile.setOnClickListener(clickListener);
//        btnAddAddress.setOnClickListener(clickListener);
//        btnLogout.setOnClickListener(clickListener);

        return view;
    }

    // Click listener for all buttons
    private final View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == btnSelectImage) {
                openImageChooser();
            } else if (v == btnUpdateProfile) {
                updateProfile();
            } else if (v == btnAddAddress) {
                addAddress();
            } else if (v == btnLogout) {
                logout();
            }
        }
    };

    // Open gallery to select an image
    private void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    // Handle image selection result
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), imageUri);
                profileImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "Image selection failed!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Update profile logic
    private void updateProfile() {
        String name = etName.getText().toString().trim();
        String crop = etCrop.getText().toString().trim();
        String landSize = etLand.getText().toString().trim();

        if (name.isEmpty() || crop.isEmpty() || landSize.isEmpty()) {
            Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "Profile Updated!", Toast.LENGTH_SHORT).show();
            // Implement API call to update profile in database
        }
    }

    // Add Address logic
    // Add Address logic
    private void addAddress() {
        Intent intent = new Intent(getActivity(), UserAddressActivity.class);
        startActivity(intent);
    }

    // Logout logic
    private void logout() {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }
}

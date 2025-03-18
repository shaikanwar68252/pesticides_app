package com.example.pesticidessellingapp.userScreens;

import static com.example.pesticidessellingapp.api.ApiClient.BASE_URL;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.pesticidessellingapp.Module.Product;
import com.example.pesticidessellingapp.Module.ProductResponse;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.databinding.ActivityProductDetailsBinding;

public class Activity_Product_Details extends AppCompatActivity {


    ActivityProductDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Product product = getIntent().getParcelableExtra("product");


        if (product != null) {
            Glide.with(binding.getRoot())
                    .load(BASE_URL + product.getImageUrl())
                    .placeholder(R.drawable.image_uploader)
                    .error(R.drawable.image_uploader)
                    .into(binding.productImage);

            binding.productName.setText(product.getProductName());
            binding.description.setText(product.getDescription());
            binding.productPrice.setText(product.getPrice());
            binding.productOffPrice.setText(product.getPrice());
            //binding.

        }


    }
}
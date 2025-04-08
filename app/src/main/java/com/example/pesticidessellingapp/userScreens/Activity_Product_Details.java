package com.example.pesticidessellingapp.userScreens;

import static com.example.pesticidessellingapp.api.ApiClient.BASE_URL;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
//import androidx.core.view.ViewCompat.OnApplyWindowInsetsListener;
import android.view.WindowInsets;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bumptech.glide.Glide;
import com.example.pesticidessellingapp.Module.Product;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.databinding.ActivityProductDetailsBinding;

public class Activity_Product_Details extends AppCompatActivity {

    ActivityProductDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);  // If you are using edge-to-edge to enable full-screen mode

        binding = ActivityProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get the product data from the intent
        Product product = getIntent().getParcelableExtra("product");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main87686), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // If the product object is not null, populate the views
        if (product != null) {
            String imgUrl = BASE_URL + product.getImageUrl();
            Glide.with(binding.getRoot())
                    .load(imgUrl)
                    .placeholder(R.drawable.image_uploader)
                    .error(R.drawable.image_uploader)
                    .into(binding.productImage);

            binding.productName.setText(product.getProductName());
            binding.description.setText(product.getDescription());
            binding.productPrice.setText(product.getPrice());
            binding.productOffPrice.setText(product.getPrice());

            binding.description.setText(product.getDescription());
            binding.keyfeatures.setText(product.getKeyFeatures());
            binding.safetyPrecautions.setText(product.getSafetyPrecautions());
            binding.quantity.setText( product.getQuantityAvailable() + " " + product.getUnit());
            binding.technicalSpecifications1.setText(product.getTechnicalSpecifications());
        }
    }
}

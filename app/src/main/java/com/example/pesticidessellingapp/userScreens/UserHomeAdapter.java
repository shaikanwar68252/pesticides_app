package com.example.pesticidessellingapp.userScreens;

import static com.example.pesticidessellingapp.api.ApiClient.BASE_URL;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pesticidessellingapp.Module.ProductResponse;
import com.example.pesticidessellingapp.R;

import java.util.List;

public class UserHomeAdapter extends RecyclerView.Adapter<UserHomeAdapter.ViewHolder> {
    private Context context;
    private List<ProductResponse.Product> productList;

    public UserHomeAdapter(Context context, List<ProductResponse.Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_home_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductResponse.Product product = productList.get(position);
        holder.productName.setText(product.getProductName());
        holder.productPrice.setText("₹ " + product.getPrice());

        String imgUrl = BASE_URL + product.getImageUrl();
        Glide.with(context)
                .load(imgUrl)
                .placeholder(R.drawable.image_1)
                .into(holder.productImage);

        // ✅ Make the entire CardView clickable
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(context, Activity_Product_Details.class);
            intent.putExtra("name", product.getProductName());
            intent.putExtra("price", String.valueOf(product.getPrice())); // Convert price to string
            intent.putExtra("imageUrl", product.getImageUrl());

            intent.pu
            context.startActivity(intent);
        });

        holder.addButton.setOnClickListener(v -> {
            // ✅ Handle add button click (e.g., add to cart)
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName, productPrice;
        Button addButton;
        CardView cardView; // ✅ Added CardView reference

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name_homeitem);
            productPrice = itemView.findViewById(R.id.product_price_userhome);
            addButton = itemView.findViewById(R.id.add_button);
            cardView = itemView.findViewById(R.id.item55); // ✅ Ensure this ID matches CardView in XML
        }
    }
}

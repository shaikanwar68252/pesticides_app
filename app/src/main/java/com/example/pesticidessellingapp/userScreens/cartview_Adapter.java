package com.example.pesticidessellingapp.userScreens;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pesticidessellingapp.R;

import java.util.List;

public class cartview_Adapter extends RecyclerView.Adapter<cartview_Adapter.CartViewHolder> {
    private List<CartViewModel> cartItems;
    private Context context;

    public cartview_Adapter(Context context, List<CartViewModel> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartViewModel item = cartItems.get(position);

        // Set data to views
        holder.productName.setText(item.getProductName());
        holder.category.setText(item.getCategory());
        holder.productPrice.setText("$" + item.getPrice());
        holder.productQuantity.setText(String.valueOf(item.getQuantity()));

        // **Set image from drawable resource**
        holder.productImage.setImageResource(item.getImageResId());

        // Increase quantity
        holder.btnIncrease.setOnClickListener(v -> {
            item.increaseQuantity();
            notifyItemChanged(position);
        });

        // Decrease quantity
        holder.btnDecrease.setOnClickListener(v -> {
            item.decreaseQuantity();
            notifyItemChanged(position);
        });

        // Delete item
        holder.btnDelete.setOnClickListener(v -> {
            cartItems.remove(position);
            notifyItemRemoved(position);
            Toast.makeText(context, "Item Removed", Toast.LENGTH_SHORT).show();
        });

        // **Navigate to Check_Out.java when btnProceedRental is clicked**
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, Check_Out.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView productName, category, productPrice, productQuantity;
        ImageView productImage, btnIncrease, btnDecrease, btnDelete;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            // Initialize UI components
            productName = itemView.findViewById(R.id.product_name);
            category = itemView.findViewById(R.id.tv_status);
            productPrice = itemView.findViewById(R.id.product_price);
            productQuantity = itemView.findViewById(R.id.product_quantity);
            productImage = itemView.findViewById(R.id.product_image112);
            btnIncrease = itemView.findViewById(R.id.btn_increase);
            btnDecrease = itemView.findViewById(R.id.btn_decrease);
            btnDelete = itemView.findViewById(R.id.btn_delete);
        }
    }
}

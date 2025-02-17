package com.example.pesticidessellingapp.userScreens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.pesticidessellingapp.R;

import java.util.List;

public class cartview_Adapter extends RecyclerView.Adapter<cartview_Adapter.CartViewHolder> {
    private Context context;
    private List<cartview_model> cartItems;

    public cartview_Adapter(Context context, List<cartview_model> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_layout, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        cartview_model item = cartItems.get(position);
        holder.productName.setText(item.getProductName());
        holder.productPrice.setText("$" + item.getPrice());
        holder.productQuantity.setText("Quantity: " + item.getQuantity());
        Glide.with(context).load(item.getImageUrl()).into(holder.productImage);

        holder.removeButton.setOnClickListener(v -> {
            removeItem(position);
        });
    }

    public void removeItem(int position) {
        if (position >= 0 && position < cartItems.size()) {
            cartItems.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, cartItems.size());
        }
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView productName, productPrice, productQuantity;
        ImageView productImage;
        Button removeButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.cart_item_name);
            productPrice = itemView.findViewById(R.id.cart_item_price);
            productQuantity = itemView.findViewById(R.id.cart_item_quantity);
            productImage = itemView.findViewById(R.id.cart_item_image);
            removeButton = itemView.findViewById(R.id.cart_remove_button);
        }
    }
}

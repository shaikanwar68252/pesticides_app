package com.example.pesticidessellingapp.userScreens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pesticidessellingapp.Module.Properties;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.api.ApiClient;

import java.util.List;

public class UserRentalAdapter extends RecyclerView.Adapter<UserRentalAdapter.ViewHolder> {

    private Context context;
    private List<Properties> rentalList;
    private OnRentalItemClickListener listener;

    // Interface for item click
    public interface OnRentalItemClickListener {
        void onRentalItemClick(int position, Properties rentalItem);
    }

    // Constructor accepting context, list, and listener
    public UserRentalAdapter(Context context, List<Properties> rentalList, OnRentalItemClickListener listener) {
        this.context = context;
        this.rentalList = rentalList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.addrental_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Properties rentalItem = rentalList.get(position);

        holder.txtProductName.setText(rentalItem.getTitle());
        holder.txtProductPrice.setText(rentalItem.getRate_per_day());

        holder.location.setText(rentalItem.getLocation());

        String imageUrl = ApiClient.BASE_URL + rentalItem.getImage_path();

        // Load image using Glide
        Glide.with(context)
                .load(imageUrl)
                .placeholder(R.drawable.home_placeholder)
                .error(R.drawable.home_placeholder)
                .into(holder.imgProduct);

        // Handle item click
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onRentalItemClick(position, rentalItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rentalList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtProductName, txtProductPrice;
        ImageView imgProduct;
        CardView itemRent;
        TextView location;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtProductName = itemView.findViewById(R.id.pro_rent1);
            txtProductPrice = itemView.findViewById(R.id.pro_rate1);
            imgProduct = itemView.findViewById(R.id.product_image12);
            itemRent = itemView.findViewById(R.id.item_rent);
            location = itemView.findViewById(R.id.location);

        }
    }
}

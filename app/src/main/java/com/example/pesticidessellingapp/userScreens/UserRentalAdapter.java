package com.example.pesticidessellingapp.userScreens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pesticidessellingapp.R;

import java.util.List;

public class UserRentalAdapter extends RecyclerView.Adapter<UserRentalAdapter.ViewHolder> {

    private Context context;
    private List<UserRentalModel> rentalList;
    private OnItemClickListener onItemClickListener;

    // Interface for item click listener
    public interface OnItemClickListener {
        void onItemClick(int position, UserRentalModel rentalItem);
    }

    // Constructor with listener
    public UserRentalAdapter(Context context, List<UserRentalModel> rentalList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.rentalList = rentalList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.addrental_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserRentalModel rentalItem = rentalList.get(position);

//        // Set product details
//        holder.productName.setText(rentalItem.getProductName());
//        holder.productPrice.setText(rentalItem.getProductPrice());
//        Glide.with(context).load(rentalItem.getProductImage()).into(holder.productImage);
//
//        // Handle "Rent Now" button click
//        holder.btnRentNow.setOnClickListener(v -> {
//            String selectedDate = holder.editTextDate.getText().toString().trim();
//            if (selectedDate.isEmpty()) {
//                Toast.makeText(context, "Please select a date before renting.", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            Intent intent;
//
//            // Determine activity based on product name
//            if (rentalItem.getProductName().toLowerCase().contains("tractor")) {
//                intent = new Intent(context, Tractors_Details.class);
//            } else if (rentalItem.getProductName().toLowerCase().contains("land")) {
//                intent = new Intent(context, Land_Details.class);
//            } else {
//                Toast.makeText(context, "Invalid item type", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            // Pass data to the activity
//            intent.putExtra("item_name", rentalItem.getProductName());
//            intent.putExtra("image_url", rentalItem.getProductImage());
//            intent.putExtra("price", rentalItem.getProductPrice());
//            intent.putExtra("selected_date", selectedDate);
//            context.startActivity(intent);
//        });
//
//        // Handle "Verify Documents" button click
//        holder.btnVerifyDocs.setOnClickListener(v ->
//                Toast.makeText(context, "Verifying Documents...", Toast.LENGTH_SHORT).show()
//        );
//
//        // Handle item click (row click)
//        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(position, rentalItem));
    }

    @Override
    public int getItemCount() {
        return rentalList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName, productPrice;
        EditText editTextDate;
        Button btnRentNow, btnVerifyDocs;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image1);


        }
    }
}

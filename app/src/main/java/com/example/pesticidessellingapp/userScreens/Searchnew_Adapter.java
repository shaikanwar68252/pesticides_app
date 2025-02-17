package com.example.pesticidessellingapp.userScreens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pesticidessellingapp.R;

import java.util.List;

public class Searchnew_Adapter extends RecyclerView.Adapter<Searchnew_Adapter.ViewHolder> {
    private Context context;
    private List<Module_Search> productList;

    public Searchnew_Adapter(Context context, List<Module_Search> productList) {
        this.context = context;
        this.productList = productList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView productName, productCategory, productPrice, productDescription;
        Button buyButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productCategory = itemView.findViewById(R.id.productCategory1);
            productPrice = itemView.findViewById(R.id.productPrice1);
            productDescription = itemView.findViewById(R.id.productDescription1);
            buyButton = itemView.findViewById(R.id.buyButton1);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Module_Search product = productList.get(position);
        holder.productName.setText(product.getProductName());
        holder.productCategory.setText(product.getCategory());
        holder.productPrice.setText(product.getPrice());
        holder.productDescription.setText(product.getDescription());

        holder.buyButton.setOnClickListener(v -> {
            // Handle buy button click
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}

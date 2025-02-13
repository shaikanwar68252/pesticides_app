package com.example.pesticidessellingapp;
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
import java.util.List;

public class Home_Adapter extends RecyclerView.Adapter<Home_Adapter.ViewHolder> {
    private Context context;
    private List<Model_Home> productList;

    public Home_Adapter(Context context, List<Model_Home> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model_Home product = productList.get(position);
        holder.productName.setText(product.getName());
        holder.productPrice.setText("$ " + product.getPrice());

        Glide.with(context).load(product.getImageUrl()).into(holder.productImage);

        holder.addButton.setOnClickListener(v -> {
            // Handle add button click (e.g., add to cart)
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            addButton = itemView.findViewById(R.id.add_button);
        }
    }
}

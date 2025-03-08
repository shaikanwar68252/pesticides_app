package com.example.pesticidessellingapp.userScreens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pesticidessellingapp.R;

import java.util.List;

public class Adapter_Orders extends RecyclerView.Adapter<Adapter_Orders.OrderViewHolder> {

    private Context context;
    private List<OrderModel> orderList;

    public Adapter_Orders(Context context, List<OrderModel> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.myorder_item, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        OrderModel order = orderList.get(position);

        holder.tvOrderId.setText(order.getOrderId());
        holder.tvOrderDate.setText(order.getOrderDate());
//        holder.tvStatus.setText(""+order.getStatus());
        holder.tvProductName.setText(order.getProductName());
        holder.tvQuantity.setText("Quantity: " + order.getQuantity());
        holder.tvPrice.setText("$" + order.getPrice());
        holder.ivProductImage.setImageResource(order.getProductImage());

        // Change color based on status
//        if (order.getStatus().equals("Delivered")) {
//            holder.tvStatus.setTextColor(context.getResources().getColor(android.R.color.holo_green_dark));
//        } else if (order.getStatus().equals("Pending")) {
//            holder.tvStatus.setTextColor(context.getResources().getColor(android.R.color.holo_orange_dark));
//        }
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView tvOrderId, tvOrderDate, tvStatus, tvProductName, tvQuantity, tvPrice;
        ImageView ivProductImage;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOrderId = itemView.findViewById(R.id.tv_order);
            tvOrderDate = itemView.findViewById(R.id.tv_order_date);
            tvStatus = itemView.findViewById(R.id.tv_status);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvQuantity = itemView.findViewById(R.id.tv_quantity);
            tvPrice = itemView.findViewById(R.id.tv_price);
            ivProductImage = itemView.findViewById(R.id.iv_product_image);
        }
    }
}

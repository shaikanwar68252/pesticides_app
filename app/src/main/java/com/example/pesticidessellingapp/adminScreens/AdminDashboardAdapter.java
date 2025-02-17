package com.example.pesticidessellingapp.adminScreens;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pesticidessellingapp.R;

import java.util.List;

public class AdminDashboardAdapter extends RecyclerView.Adapter<AdminDashboardAdapter.ViewHolder> {
    private List<AdminDashboardModel> itemList;
    private Context context;
    private OnItemClickListener onItemClickListener;  // Click Listener

    public AdminDashboardAdapter(Context context, List<AdminDashboardModel> itemList, OnItemClickListener listener) {
        this.context = context;
        this.itemList = itemList;
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adminpage_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AdminDashboardModel model = itemList.get(position);
        holder.textView.setText(model.getButtonText());  // Set text instead of button

        holder.textView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);  // Updated to match adminpage_item.xml
        }
    }
}

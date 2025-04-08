package com.example.pesticidessellingapp.userScreens;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pesticidessellingapp.Module.GetPropertyResponse;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.api.ApiClient;
import com.example.pesticidessellingapp.api.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRentalFragment extends Fragment {

    private RecyclerView recyclerViewCart;
    private Button btnProceedRental;
    private UserRentalAdapter adapter;
    private List<UserRentalModel> rentalList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout
        View view = inflater.inflate(R.layout.fragment_user_rental, container, false);

        recyclerViewCart = view.findViewById(R.id.recyclerView_cart);
        btnProceedRental = view.findViewById(R.id.btn_proceed_rental);

        btnProceedRental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddRentalActivity.class);
                Toast.makeText(requireContext(), "Proceeding with Rental", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });




        // Sample rental data
        rentalList = new ArrayList<>();
        rentalList.add(new UserRentalModel("Tractor X1", "https://example.com/tractor1.jpg", "1000/day"));
        rentalList.add(new UserRentalModel("Land Plot A", "https://example.com/land1.jpg", "5000/month"));
        rentalList.add(new UserRentalModel("Harvester H3", "https://example.com/harvester3.jpg", "1800/day"));
        rentalList.add(new UserRentalModel("Plow P1", "https://example.com/plow1.jpg", "800/day"));

        // Set LayoutManager (Vertical)
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewCart.setLayoutManager(layoutManager);

        ApiClient.getClient().create(ApiService.class).getproperties().enqueue(new Callback<GetPropertyResponse>() {
            @Override
            public void onResponse(Call<GetPropertyResponse> call, Response<GetPropertyResponse> response) {
                if(response.isSuccessful()) {
                    adapter = new UserRentalAdapter(requireContext(), response.body().getProperties(), (position, rentalItem) -> {
                        Intent intent = new Intent(requireContext(), Tractors_Details2.class);

                        // Pass data to the details activity
//                        intent.putExtra("item_name", rentalItem.getTitle());
//                        intent.putExtra("image_url", rentalItem.getImage_path());
//                        intent.putExtra("price", rentalItem.getRate_per_day());
                        intent.putExtra("item",rentalItem);

                        startActivity(intent);
                    });


                    recyclerViewCart.setAdapter(adapter);

                }else {
                    Toast.makeText(requireContext(), response.message(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<GetPropertyResponse> call, Throwable t) {
                Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        // Proceed Rental button


        return view;
    }
}
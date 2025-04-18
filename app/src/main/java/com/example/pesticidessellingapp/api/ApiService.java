package com.example.pesticidessellingapp.api;

import com.example.pesticidessellingapp.ApiRequest.LoginRequest;
import com.example.pesticidessellingapp.ApiRequest.UserSignupRequest;
import com.example.pesticidessellingapp.ApiResponse.LoginResponse;
import com.example.pesticidessellingapp.ApiResponse.PostPropertyResponse;
import com.example.pesticidessellingapp.ApiResponse.SignupResponse;
import com.example.pesticidessellingapp.Module.GetPropertyResponse;
import com.example.pesticidessellingapp.Module.ProductResponse;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    @POST("signup_users.php")
    Call<SignupResponse> signupUser(@Body UserSignupRequest userSignupRequest);

    @POST("users_login.php")
    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);

    @Multipart
    @POST("product_Admin.php")
    Call<LoginResponse> productAdmin(
            @Part("Product_Name") RequestBody Product_Name,
            @Part("Category") RequestBody Category,
            @Part("Price") RequestBody Price,
            @Part("Description") RequestBody Description,
            @Part("Stock") RequestBody Stock,
            @Part("Image") RequestBody Image,
            @Part("Added_By") RequestBody Added_By,
            @Part("date") RequestBody date
    );

    @Multipart
    @POST("add_product.php")
    Call<Void> addProduct(
            @Part("product_name") RequestBody productName,
            @Part("brand") RequestBody brand,
            @Part("price") RequestBody price,
            @Part("discount") RequestBody discount,
            @Part("stock_status") RequestBody stockStatus,
            @Part("description") RequestBody description,
            @Part("units") RequestBody units,
            @Part("qantityAvailable") RequestBody qantityAvailable,
            @Part("key_features") RequestBody keyFeatures,
            @Part("safety_precautions") RequestBody safetyPrecautions,
            @Part("technical_details") RequestBody technicalDetails,
            @Part MultipartBody.Part image
    );

    @Multipart
    @POST("add_property.php") // Change to your actual PHP endpoint
    Call<PostPropertyResponse> postProperty(
            @Part("user_id") RequestBody userId,
            @Part("type") RequestBody type,
            @Part("title") RequestBody title,
            @Part("location") RequestBody location,
            @Part("area") RequestBody area,
            @Part("rate") RequestBody rate,
            @Part("description") RequestBody description,
            @Part List<MultipartBody.Part> photos
    );

    @GET("fetchAllProducts.php")
    Call<ProductResponse> getProducts();

    @GET("fetch_properties.php")
    Call<GetPropertyResponse> getproperties();

}

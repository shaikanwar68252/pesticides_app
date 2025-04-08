package com.example.pesticidessellingapp.api;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ApiClient {
    public static final String BASE_URL = "http://192.168.125.190/Pesticides/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            // Create a logging interceptor for Retrofit
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);  // Log body content (request/response)

            // Create OkHttpClient with logging and timeouts
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)  // Increase timeout to 30 seconds
                    .readTimeout(30, TimeUnit.SECONDS)     // Increase read timeout to 30 seconds
                    .writeTimeout(30, TimeUnit.SECONDS)    // Increase write timeout to 30 seconds
                    .addInterceptor(interceptor)  // Add logging interceptor
                    .build();

            // Create a Gson instance with lenient parsing
            Gson gson = new GsonBuilder()
                    .setLenient()  // Allow lenient JSON parsing
                    .create();

            // Build the Retrofit instance
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))  // Use the custom Gson instance
                    .client(client)  // Use the OkHttp client with logging
                    .build();
        }
        return retrofit;
    }
}

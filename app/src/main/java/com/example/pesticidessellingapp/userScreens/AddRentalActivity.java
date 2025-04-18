package com.example.pesticidessellingapp.userScreens;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.pesticidessellingapp.ApiResponse.PostPropertyResponse;
import com.example.pesticidessellingapp.R;
import com.example.pesticidessellingapp.api.ApiClient;
import com.example.pesticidessellingapp.api.ApiService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddRentalActivity extends AppCompatActivity {

    private static final int PICK_IMAGES_REQUEST = 1;
    private RadioGroup categoryGroup;
    private EditText etPropertyTitle, etLocation, etArea, etRate, etDescription;
    private CheckBox cbTerms;
    private Button btnListProperty;
    private LinearLayout uploadPhotosLayout;
    private List<Uri> selectedImages = new ArrayList<>();
    private ProgressDialog progressDialog;

    private final ActivityResultLauncher<String> permissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    selectImages();
                } else {
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_rental);

        categoryGroup = findViewById(R.id.categoryGroup);
        etPropertyTitle = findViewById(R.id.etPropertyTitle);
        etLocation = findViewById(R.id.etLocation);
        etArea = findViewById(R.id.etArea);
        etRate = findViewById(R.id.etRate);
        etDescription = findViewById(R.id.etDescription);
        cbTerms = findViewById(R.id.cbTerms);
        btnListProperty = findViewById(R.id.btnListProperty);
        uploadPhotosLayout = findViewById(R.id.uploadPhotosLayout);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Posting property...");

        uploadPhotosLayout.setOnClickListener(v -> checkPermissionAndSelectImages());

        btnListProperty.setOnClickListener(v -> postProperty());
    }

    private void checkPermissionAndSelectImages() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            // Android 13+
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_IMAGES)
                    != PackageManager.PERMISSION_GRANTED) {
                permissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES);
            } else {
                selectImages();
            }
        } else {
            // Android 12 and below
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                    != PackageManager.PERMISSION_GRANTED) {
                permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
            } else {
                selectImages();
            }
        }
    }


    private void selectImages() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        startActivityForResult(Intent.createChooser(intent, "Select Images"), PICK_IMAGES_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGES_REQUEST && resultCode == RESULT_OK && data != null) {
            selectedImages.clear();
            if (data.getClipData() != null) {
                int count = data.getClipData().getItemCount();
                for (int i = 0; i < count; i++) {
                    selectedImages.add(data.getClipData().getItemAt(i).getUri());
                }
            } else if (data.getData() != null) {
                selectedImages.add(data.getData());
            }
            Toast.makeText(this, selectedImages.size() + " images selected", Toast.LENGTH_SHORT).show();
        }
    }

    private void postProperty() {
        int selectedCategoryId = categoryGroup.getCheckedRadioButtonId();
        if (selectedCategoryId == -1) {
            Toast.makeText(this, "Please select a category", Toast.LENGTH_SHORT).show();
            return;
        }
        String category = ((RadioButton) findViewById(selectedCategoryId)).getText().toString();
        String title = etPropertyTitle.getText().toString().trim();
        String location = etLocation.getText().toString().trim();
        String area = etArea.getText().toString().trim();
        String rate = etRate.getText().toString().trim();
        String description = etDescription.getText().toString().trim();

        if (title.isEmpty() || location.isEmpty() || area.isEmpty() || rate.isEmpty() || description.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!cbTerms.isChecked()) {
            Toast.makeText(this, "Please agree to terms", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.show();

        ApiService apiService = ApiClient.getClient().create(ApiService.class);

        RequestBody userId = RequestBody.create(MediaType.parse("text/plain"), getSharedPreferences("APP_SF",MODE_PRIVATE).getString("ID",""));
        RequestBody type = RequestBody.create(MediaType.parse("text/plain"), category);
        RequestBody propTitle = RequestBody.create(MediaType.parse("text/plain"), title);
        RequestBody propLocation = RequestBody.create(MediaType.parse("text/plain"), location);
        RequestBody propArea = RequestBody.create(MediaType.parse("text/plain"), area);
        RequestBody propRate = RequestBody.create(MediaType.parse("text/plain"), rate);
        RequestBody propDesc = RequestBody.create(MediaType.parse("text/plain"), description);

        List<MultipartBody.Part> photoParts = new ArrayList<>();
        for (Uri uri : selectedImages) {
            String filePath = getRealPathFromURI(uri);
            if (filePath != null) {
                File file = new File(filePath);
                RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
                MultipartBody.Part photoPart = MultipartBody.Part.createFormData("photos[]", file.getName(), requestFile);
                photoParts.add(photoPart);
            } else {
                Toast.makeText(this, "Error getting file path", Toast.LENGTH_SHORT).show();
            }
        }

        Call<PostPropertyResponse> call = apiService.postProperty(userId, type, propTitle, propLocation, propArea, propRate, propDesc, photoParts);
        call.enqueue(new Callback<PostPropertyResponse>() {
            @Override
            public void onResponse(Call<PostPropertyResponse> call, Response<PostPropertyResponse> response) {
                if (response.isSuccessful()) {
                    // Log the raw response body to check what is being returned
                    try {
                        String rawResponse = response.errorBody() != null ? response.errorBody().string() : "";
                        Log.d("RawResponse", rawResponse);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    PostPropertyResponse propertyResponse = response.body();
                    if (propertyResponse != null) {
                        // Handle success
                        progressDialog.dismiss();
                        Toast.makeText(AddRentalActivity.this, propertyResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        // Handle empty response body
                        progressDialog.dismiss();
                        Toast.makeText(AddRentalActivity.this, "Empty response", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(AddRentalActivity.this, "Failed to post property", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<PostPropertyResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(AddRentalActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getRealPathFromURI(Uri contentUri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, projection, null, null, null);
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            String filePath = cursor.getString(columnIndex);
            cursor.close();
            return filePath;
        }
        return null;
    }
}

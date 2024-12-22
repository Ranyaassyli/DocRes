package com.example.doctor.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.doctor.R;
import com.example.doctor.adapters.CategoryAdapter;
import com.example.doctor.models.Category;
import com.example.doctor.fragments.ProfileOptionsBottomSheetFragment; // Importing the Fragment

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity {

    private RecyclerView categoriesRecyclerView;
    private CategoryAdapter categoryAdapter;
    private List<Category> categoryList;
    private ImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        // Initialize views
        categoriesRecyclerView = findViewById(R.id.recyclerView_categories);
        profileImageView = findViewById(R.id.profileImage);

        // Initialize categories
        categoryList = new ArrayList<>();
        populateCategories();

        // Set up RecyclerView
        categoryAdapter = new CategoryAdapter(categoryList, category -> {
            // Handle category click
            Intent intent = new Intent(CategoriesActivity.this, DoctorListActivity.class);
            intent.putExtra("CATEGORY_ID", category.getId());
            intent.putExtra("CATEGORY_NAME", category.getName());
            startActivity(intent);
        });

        categoriesRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns
        categoriesRecyclerView.setAdapter(categoryAdapter);

        // Handle profile image click
        profileImageView.setOnClickListener(v -> {
            // Show profile options in a bottom sheet when the profile image is clicked
            ProfileOptionsBottomSheetFragment bottomSheetFragment = new ProfileOptionsBottomSheetFragment();
            bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
        });
    }

    private void populateCategories() {
        // Add categories (you can add more if needed)
        categoryList.add(new Category(1, "Dentist", R.drawable.dentiste));
        categoryList.add(new Category(2, "Radiologist", R.drawable.radiologist));
        categoryList.add(new Category(3, "Cardiologist", R.drawable.cardiologist));
        categoryList.add(new Category(4, "Dermatologist", R.drawable.dermatologist));
        categoryList.add(new Category(5, "Pediatrician", R.drawable.pediatrician));
        categoryList.add(new Category(6, "Psychiatrist", R.drawable.psychiatrist));
        categoryList.add(new Category(7, "Neurologist", R.drawable.neurologist));
        categoryList.add(new Category(8, "Orthopedist", R.drawable.orthopedist));
        categoryList.add(new Category(9, "Ophthalmologist", R.drawable.ophthalmologist));
        categoryList.add(new Category(10, "General Practitioner", R.drawable.general_practitioner));
        categoryList.add(new Category(11, "Surgeon", R.drawable.surgeon));
        categoryList.add(new Category(12, "Oncologist", R.drawable.oncologist));
        categoryList.add(new Category(13, "Gastroenterologist", R.drawable.gastroenterologist));
        categoryList.add(new Category(14, "Nephrologist", R.drawable.nephrologist));
        categoryList.add(new Category(15, "Endocrinologist", R.drawable.endocrinologist));
        categoryList.add(new Category(16, "Rheumatologist", R.drawable.rheumatologist));
        categoryList.add(new Category(17, "Urologist", R.drawable.urologist));
        categoryList.add(new Category(18, "Hematologist", R.drawable.hematologist));
        categoryList.add(new Category(19, "Pulmonologist", R.drawable.pulmonologist));
        categoryList.add(new Category(20, "Allergist", R.drawable.allergist));
    }
}

package com.example.doctor.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.doctor.R;
import com.example.doctor.fragments.ProfileOptionsBottomSheetFragment;

public class ProfileActivity extends AppCompatActivity {

    private ImageView profileImage;
    private TextView profileName;
    private Button btnEditProfile, btnSettings, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize Views
        profileImage = findViewById(R.id.profileImage);
        profileName = findViewById(R.id.profileName);
        btnEditProfile = findViewById(R.id.btnEditProfile);
        btnSettings = findViewById(R.id.btnSettings);
        btnLogout = findViewById(R.id.btnLogout);

        // Set sample data for the profile
        profileName.setText("John Doe");

        // Handle profile image click to open the bottom sheet
        profileImage.setOnClickListener(v -> {
            ProfileOptionsBottomSheetFragment profileBottomSheet = new ProfileOptionsBottomSheetFragment();
            profileBottomSheet.show(getSupportFragmentManager(), profileBottomSheet.getTag());
        });

        // Handle Edit Profile button click
        btnEditProfile.setOnClickListener(v -> {
            // Navigate to Edit Profile activity (implement if needed)
            // startActivity(new Intent(ProfileActivity.this, EditProfileActivity.class));
        });

        // Handle Settings button click
        btnSettings.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, SettingsActivity.class);
            startActivity(intent);
        });

        // Handle Logout button click
        btnLogout.setOnClickListener(v -> {
            // Implement logout functionality
            // For example: FirebaseAuth.getInstance().signOut();
            // Or navigate to the login screen
            finish(); // Close the profile activity
            // startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
        });
    }
}

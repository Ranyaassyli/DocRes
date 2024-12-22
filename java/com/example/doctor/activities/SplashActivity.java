package com.example.doctor.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.doctor.R;

public class SplashActivity extends AppCompatActivity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Initialize the "Go to Login" button
        btnLogin = findViewById(R.id.btnLogin);

        // Set an OnClickListener for the button to navigate to LoginActivity when clicked
        btnLogin.setOnClickListener(v -> navigateToLoginActivity());

        // Automatically navigate to LoginActivity after 3 seconds
        new Handler().postDelayed(() -> navigateToLoginActivity(), 3000); // Delay for 3 seconds
    }

    // Method to start LoginActivity
    private void navigateToLoginActivity() {
        Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // Close SplashActivity to prevent returning to it
    }
}

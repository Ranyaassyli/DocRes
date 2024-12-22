package com.example.doctor.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import com.example.doctor.R;

public class SettingsActivity extends AppCompatActivity {

    private Switch switchNotifications;
    private RadioButton radioLight, radioDark;
    private Button btnSaveSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initialize Views
        switchNotifications = findViewById(R.id.switchNotifications);
        radioLight = findViewById(R.id.radioLight);
        radioDark = findViewById(R.id.radioDark);
        btnSaveSettings = findViewById(R.id.btnSaveSettings);

        // Handle save settings button click
        btnSaveSettings.setOnClickListener(v -> {
            // Save the settings (e.g., using SharedPreferences or a database)
            boolean notificationsEnabled = switchNotifications.isChecked();
            String theme = radioLight.isChecked() ? "Light" : "Dark";

            // Example of saving settings
            // SharedPreferences preferences = getSharedPreferences("settings", MODE_PRIVATE);
            // SharedPreferences.Editor editor = preferences.edit();
            // editor.putBoolean("notifications", notificationsEnabled);
            // editor.putString("theme", theme);
            // editor.apply();

            // Optionally, you can restart the activity or apply changes immediately
            // For example, changing theme requires restarting the app
        });
    }
}

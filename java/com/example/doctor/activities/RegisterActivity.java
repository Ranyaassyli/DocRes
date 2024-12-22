package com.example.doctor.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.doctor.database.DatabaseHelper;
import com.example.doctor.models.User;
import com.example.doctor.utils.ValidationUtil;
import com.example.doctor.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText firstNameEditText, lastNameEditText, emailEditText, passwordEditText;
    private Button registerButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Match the correct IDs from the XML layout
        firstNameEditText = findViewById(R.id.fname);
        lastNameEditText = findViewById(R.id.lname);
        emailEditText = findViewById(R.id.addressMailSign);
        passwordEditText = findViewById(R.id.passwordSign);
        registerButton = findViewById(R.id.sing);
        dbHelper = new DatabaseHelper(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameEditText.getText().toString();
                String lastName = lastNameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Validate the input fields
                if (ValidationUtil.isValidEmail(email) && ValidationUtil.isValidPassword(password)) {
                    User newUser = new User(firstName, lastName, email, password);
                    if (dbHelper.insertUser(newUser)) {
                        Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        finish(); // Close the RegisterActivity and return to LoginActivity
                    } else {
                        Toast.makeText(RegisterActivity.this, "Error during registration", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Please enter valid data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

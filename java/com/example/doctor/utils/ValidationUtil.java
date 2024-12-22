package com.example.doctor.utils;

import android.util.Patterns;

public class ValidationUtil {

    public static boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= 6;
    }
}

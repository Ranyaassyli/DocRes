package com.example.doctor.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.doctor.R;
import com.example.doctor.activities.ProfileActivity;
import com.example.doctor.activities.SettingsActivity;
import com.example.doctor.activities.LoginActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ProfileOptionsBottomSheetFragment extends BottomSheetDialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for the bottom sheet
        View view = inflater.inflate(R.layout.fragment_profile_options, container, false);

        // Find the TextViews for each option and set click listeners
        TextView profileOption = view.findViewById(R.id.profile_option);
        TextView settingsOption = view.findViewById(R.id.settings_option);
        TextView logoutOption = view.findViewById(R.id.logout_option);

        profileOption.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), ProfileActivity.class));
            dismiss(); // Dismiss the bottom sheet after selection
        });

        settingsOption.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), SettingsActivity.class));
            dismiss();
        });

        logoutOption.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), LoginActivity.class));
            dismiss();
        });

        return view;
    }
}

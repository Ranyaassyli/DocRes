package com.example.doctor.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctor.R;
import com.example.doctor.adapters.TimeSlotAdapter;
import com.example.doctor.models.TimeSlot;

import java.util.ArrayList;
import java.util.List;

public class DoctorReservationActivity extends AppCompatActivity implements TimeSlotAdapter.OnTimeSlotClickListener {

    // Declare UI elements
    private TextView doctorName, doctorSpecialty, doctorBio, doctorCredentials, doctorLocation, consultationTypes, specialTreatments, consultationDuration;
    private RatingBar doctorRating;
    private DatePicker datePicker;
    private RecyclerView timeSlotsRecyclerView;
    private EditText patientName, patientSymptoms;
    private Button confirmAppointmentBtn;

    private TimeSlotAdapter timeSlotAdapter;  // Adapter for time slots
    private List<TimeSlot> timeSlotsList; // Your list of time slots
    private TimeSlot selectedTimeSlot; // Variable to hold the selected time slot

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_reservation);

        // Initialize UI elements
        doctorName = findViewById(R.id.doctorName);
        doctorSpecialty = findViewById(R.id.doctorSpecialty);
        doctorBio = findViewById(R.id.doctorBio);
        doctorCredentials = findViewById(R.id.doctorCredentials);
        doctorLocation = findViewById(R.id.doctorLocation);
        consultationTypes = findViewById(R.id.consultationTypes);
        specialTreatments = findViewById(R.id.specialTreatments);
        consultationDuration = findViewById(R.id.consultationDuration);
        doctorRating = findViewById(R.id.doctorRating);
        datePicker = findViewById(R.id.datePicker);
        timeSlotsRecyclerView = findViewById(R.id.timeSlotsRecyclerView);
        patientName = findViewById(R.id.patientName);
        patientSymptoms = findViewById(R.id.patientSymptoms);
        confirmAppointmentBtn = findViewById(R.id.confirmAppointmentBtn);

        // Set data for doctor details
        setDoctorDetails();

        // Initialize RecyclerView
        setupTimeSlotsRecyclerView();

        // Handle appointment reservation
        confirmAppointmentBtn.setOnClickListener(v -> reserveAppointment());
    }

    private void setDoctorDetails() {
        // Set doctor details (this could come from a data source or API)
        doctorName.setText("Dr. John Doe");
        doctorSpecialty.setText("Psychiatrist");
        doctorBio.setText("Dr. John Doe is a highly experienced Psychiatrist with over 10 years of practice.");
        doctorCredentials.setText("Certified in Psychiatrist, Affiliated with XYZ Hospital");
        doctorLocation.setText("XYZ Hospital, 123 Main St, City, Country");
        consultationTypes.setText("In-person Consultation, Video Consultation");
        specialTreatments.setText("Physical Exams, Follow-Up Appointments");
        consultationDuration.setText("Consultation Duration: 30-45 minutes");
        doctorRating.setRating(4.5f); // Set rating to 4.5 stars
    }

    private void setupTimeSlotsRecyclerView() {
        // Create a list of time slots
        timeSlotsList = new ArrayList<>();
        timeSlotsList.add(new TimeSlot("10:00 AM"));
        timeSlotsList.add(new TimeSlot("11:00 AM"));
        timeSlotsList.add(new TimeSlot("01:00 PM"));
        timeSlotsList.add(new TimeSlot("03:00 PM"));
        timeSlotsList.add(new TimeSlot("04:00 PM"));

        // Set up RecyclerView with an adapter
        timeSlotAdapter = new TimeSlotAdapter(timeSlotsList, this); // Pass this activity as the listener
        timeSlotsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        timeSlotsRecyclerView.setAdapter(timeSlotAdapter);
    }

    @Override
    public void onTimeSlotClick(TimeSlot timeSlot) {
        // Update the selected time slot
        selectedTimeSlot = timeSlot;
        // Optionally, update the UI to show the selected time
        Toast.makeText(this, "Selected time: " + timeSlot.getTimeSlot(), Toast.LENGTH_SHORT).show();
    }

    private void reserveAppointment() {
        // Get the patient details from the UI
        String patientFullName = patientName.getText().toString();
        String symptoms = patientSymptoms.getText().toString();

        // Get the selected date
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        // Check if a time slot is selected
        if (selectedTimeSlot != null) {
            String confirmationMessage = "Appointment Reserved for " + patientFullName + " on " + day + "/" + (month + 1) + "/" + year +
                    " at " + selectedTimeSlot.getTimeSlot();
            // Show a confirmation message
            Toast.makeText(this, confirmationMessage, Toast.LENGTH_LONG).show();

            // After confirmation, navigate back to the category page
            Intent intent = new Intent(DoctorReservationActivity.this, CategoriesActivity.class); // Change to your category activity class
            startActivity(intent);
            finish(); // Optionally close this activity
        } else {
            // Show an error message if no time slot is selected
            Toast.makeText(this, "Please select a time slot", Toast.LENGTH_SHORT).show();
        }
    }
}

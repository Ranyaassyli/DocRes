package com.example.doctor.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.doctor.R;
import com.example.doctor.adapters.DoctorAdapter;
import com.example.doctor.models.Doctor;

import java.util.ArrayList;
import java.util.List;

public class DoctorListActivity extends AppCompatActivity {

    private RecyclerView doctorRecyclerView;
    private List<Doctor> doctorList;
    private int categoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_list);

        // Retrieve category ID and name
        categoryId = getIntent().getIntExtra("CATEGORY_ID", -1);

        doctorRecyclerView = findViewById(R.id.doctorRecyclerView);
        doctorRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        doctorList = new ArrayList<>();
        populateDoctors();

        DoctorAdapter adapter = new DoctorAdapter(this, doctorList);
        doctorRecyclerView.setAdapter(adapter);
    }

    private void populateDoctors() {
        // Populate doctor list based on the category ID
        switch (categoryId) {
            case 1: // Dentist
                doctorList.add(new Doctor(1, "Dentist Dr. Alice", "Dentist", 4.5f, R.drawable.doc1));
                doctorList.add(new Doctor(2, "Dentist Dr. Hend", "Dentist", 4.7f, R.drawable.doc2));
                doctorList.add(new Doctor(4, "Dentist Dr. Carol", "Dentist", 4.6f, R.drawable.doc4));
                doctorList.add(new Doctor(5, "Dentist Dr. Ranya", "Dentist", 4.7f, R.drawable.doc5));
                doctorList.add(new Doctor(6, "Dentist Dr. Chayma", "Dentist", 4.6f, R.drawable.doc6));
                break;
            case 2: // Radiologist
                doctorList.add(new Doctor(7, "Radiologist Dr. David", "Radiologist", 4.2f, R.drawable.doc7));
                doctorList.add(new Doctor(8, "Radiologist Dr. Emma", "Radiologist", 4.3f, R.drawable.doc8));
                doctorList.add(new Doctor(9, "Radiologist Dr. Walid", "Radiologist", 4.2f, R.drawable.doc9));
                doctorList.add(new Doctor(10, "Radiologist Dr. Emna", "Radiologist", 4.3f, R.drawable.doc10));
                doctorList.add(new Doctor(11, "Radiologist Dr. Mohamed", "Radiologist", 4.3f, R.drawable.doc11));
                break;
            case 3: // Cardiologist
                doctorList.add(new Doctor(12, "Cardiologist Dr. Frank", "Cardiologist", 4.8f, R.drawable.doc12));
                doctorList.add(new Doctor(13, "Cardiologist Dr. Grace", "Cardiologist", 4.9f, R.drawable.doc13));
                doctorList.add(new Doctor(14, "Cardiologist Dr. Frank", "Cardiologist", 4.8f, R.drawable.doc14));
                doctorList.add(new Doctor(15, "Cardiologist Dr. Grace", "Cardiologist", 4.9f, R.drawable.doc15));
                doctorList.add(new Doctor(16, "Cardiologist Dr. John", "Cardiologist", 4.8f, R.drawable.doc16));
                doctorList.add(new Doctor(17, "Cardiologist Dr. Grace", "Cardiologist", 4.9f, R.drawable.doc17));
                break;
            case 4: // Dermatologist
                doctorList.add(new Doctor(18, "Dermatologist Dr. Harry", "Dermatologist", 4.4f, R.drawable.doc18));
                doctorList.add(new Doctor(19, "Dermatologist Dr. Irene", "Dermatologist", 4.6f, R.drawable.doc19));
                doctorList.add(new Doctor(20, "Dermatologist Dr. Salah", "Dermatologist", 4.4f, R.drawable.doc20));
                doctorList.add(new Doctor(21, "Dermatologist Dr. Sayren", "Dermatologist", 4.6f, R.drawable.doc21));
                doctorList.add(new Doctor(22, "Dermatologist Dr. Sami", "Dermatologist", 4.4f, R.drawable.doc22));
                doctorList.add(new Doctor(23, "Dermatologist Dr. Ahmed", "Dermatologist", 4.6f, R.drawable.doc23));
                break;
            case 5: // Pediatrician
                doctorList.add(new Doctor(24, "Pediatrician Dr. John", "Pediatrician", 4.5f, R.drawable.doc24));
                doctorList.add(new Doctor(25, "Pediatrician Dr. Kelly", "Pediatrician", 4.7f, R.drawable.doc25));
                doctorList.add(new Doctor(26, "Pediatrician Dr. Kendall", "Pediatrician", 4.5f, R.drawable.doc26));
                doctorList.add(new Doctor(27, "Pediatrician Dr. Keli", "Pediatrician", 4.7f, R.drawable.doc27));

                break;
            case 6: // Psychiatrist
                doctorList.add(new Doctor(32, "Psych AI", "Robot Psychologist", 5.0f, R.drawable.psychai));
                doctorList.add(new Doctor(28, "Psychiatrist Dr. Leo", "Psychiatrist", 4.7f, R.drawable.doc12));
                doctorList.add(new Doctor(29, "Psychiatrist Dr. Mia", "Psychiatrist", 4.8f, R.drawable.doc29));
                doctorList.add(new Doctor(30, "Psychiatrist Dr. Leonardo", "Psychiatrist", 4.7f, R.drawable.doc30));
                doctorList.add(new Doctor(31, "Psychiatrist Dr. Maissa", "Psychiatrist", 4.8f, R.drawable.doc31));

                break;
            // Repeat similar structure for other categories
            default:
                Toast.makeText(this, "Invalid category!", Toast.LENGTH_SHORT).show();
                finish();
                return;
        }
    }

}

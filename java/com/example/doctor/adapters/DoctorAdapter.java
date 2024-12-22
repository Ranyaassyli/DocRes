package com.example.doctor.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.doctor.R;
import com.example.doctor.models.Doctor;
import com.example.doctor.activities.DoctorReservationActivity;
import java.util.List;
import com.example.doctor.activities.MainActivity;
public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {

    private Context context;
    private List<Doctor> doctorList;

    public DoctorAdapter(Context context, List<Doctor> doctorList) {
        this.context = context;
        this.doctorList = doctorList;
    }

    @NonNull
    @Override
    public DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_doctor, parent, false);
        return new DoctorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorViewHolder holder, int position) {
        Doctor doctor = doctorList.get(position);
        holder.nameTextView.setText(doctor.getName());
        holder.specialtyTextView.setText(doctor.getSpecialty());
        holder.ratingBar.setRating(doctor.getRating());
        holder.profileImageView.setImageResource(doctor.getProfileImageResId());

        // Special click handling for "Robot Psychologist"
        holder.itemView.setOnClickListener(v -> {
            if ("Psy Robot".equals(doctor.getName())) {
                // Navigate to the robotic psychological evaluation
                Intent intent = new Intent(context, MainActivity.class);
                context.startActivity(intent);
            } else {
                // Handle navigation for real doctors
                Intent intent = new Intent(context, DoctorReservationActivity.class);
                intent.putExtra("doctorId", doctor.getId());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public static class DoctorViewHolder extends RecyclerView.ViewHolder {
        ImageView profileImageView;
        TextView nameTextView, specialtyTextView;
        RatingBar ratingBar;

        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImageView = itemView.findViewById(R.id.doctorImage);
            nameTextView = itemView.findViewById(R.id.doctorName);
            specialtyTextView = itemView.findViewById(R.id.doctorSpecialty);
            ratingBar = itemView.findViewById(R.id.doctorRating);
        }
    }
}

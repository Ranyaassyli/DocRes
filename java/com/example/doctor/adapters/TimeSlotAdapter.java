package com.example.doctor.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.doctor.R;
import com.example.doctor.models.TimeSlot;
import java.util.List;

public class TimeSlotAdapter extends RecyclerView.Adapter<TimeSlotAdapter.TimeSlotViewHolder> {

    private List<TimeSlot> timeSlotList;
    private OnTimeSlotClickListener listener;

    public TimeSlotAdapter(List<TimeSlot> timeSlotList, OnTimeSlotClickListener listener) {
        this.timeSlotList = timeSlotList;
        this.listener = listener;
    }

    @Override
    public TimeSlotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_time_slot, parent, false);
        return new TimeSlotViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TimeSlotViewHolder holder, int position) {
        TimeSlot timeSlot = timeSlotList.get(position);
        holder.timeTextView.setText(timeSlot.getTimeSlot());

        // Set click listener for each item
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onTimeSlotClick(timeSlot); // Trigger the listener with the selected time slot
            }
        });
    }

    @Override
    public int getItemCount() {
        return timeSlotList.size();
    }

    public static class TimeSlotViewHolder extends RecyclerView.ViewHolder {
        TextView timeTextView;

        public TimeSlotViewHolder(View itemView) {
            super(itemView);
            timeTextView = itemView.findViewById(R.id.timeSlotText);
        }
    }

    public interface OnTimeSlotClickListener {
        void onTimeSlotClick(TimeSlot timeSlot); // Method to handle click
    }
}

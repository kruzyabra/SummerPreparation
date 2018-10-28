package ru.pavlenko.julia.summerpreparation.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ru.pavlenko.julia.summerpreparation.R;
import ru.pavlenko.julia.summerpreparation.model.Workout;

public class WorkoutViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    TextView description;
    TextView dateTextView;
    TextView repeatTextView;
    TextView weightTextView;

    public WorkoutViewHolder(@NonNull View itemView) {
        super(itemView);

        initGUI(itemView);
    }

    private void initGUI(View itemView) {
        title          = itemView.findViewById(R.id.title);
        description    = itemView.findViewById(R.id.description);
        dateTextView   = itemView.findViewById(R.id.dateTextView);
        repeatTextView = itemView.findViewById(R.id.repeatTextView);
        weightTextView = itemView.findViewById(R.id.weightTextView);
    }

    public void bindView(Workout workout) {
        title.setText(workout.getTitle());
        description.setText(workout.getDescription());
        dateTextView.setText(workout.getRecordDate());
        repeatTextView.setText(workout.getRecordNumberOfReps());
        weightTextView.setText(workout.getRecordWeight());
    }
}

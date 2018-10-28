package ru.pavlenko.julia.summerpreparation.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.pavlenko.julia.summerpreparation.R;
import ru.pavlenko.julia.summerpreparation.model.Workout;
import ru.pavlenko.julia.summerpreparation.model.WorkoutList;

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutViewHolder> {
    List<Workout> workoutList = WorkoutList.getInstance().getWorkouts();

    @NonNull
    @Override
    public WorkoutViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);

        return new WorkoutViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkoutViewHolder workoutViewHolder, int i) {
        workoutViewHolder.bindView(workoutList.get(i));
    }

    @Override
    public int getItemCount() {
        return workoutList != null ? workoutList.size() : 0;
    }
}

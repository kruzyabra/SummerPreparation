package ru.pavlenko.julia.summerpreparation.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class WorkoutList {
    private static final WorkoutList ourInstance = new WorkoutList();

    private List<Workout> workouts;

    public static WorkoutList getInstance() {
        return ourInstance;
    }

    private WorkoutList() {
        workouts = new ArrayList<>();

        fillWorkoutsList();
    }

    private void fillWorkoutsList() {
        Random random = new Random();
        for (int i = 0; i < 18; i++) {
            Workout workout = new Workout("Упражнение №" + random.nextInt(18), getDescription());
            workout.setRecordDate(new Date());
            workout.setRecordWeight(random.nextInt(101));
            workout.setRecordNumberOfReps(random.nextInt(101));

            workouts.add(workout);
        }
    }

    private String getDescription() {
        return "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis dicta dignissimos, dolor dolore ex illo in, nulla omnis perspiciatis provident quam qui quidem reiciendis reprehenderit sit sunt unde voluptatem voluptatum?";
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }
}

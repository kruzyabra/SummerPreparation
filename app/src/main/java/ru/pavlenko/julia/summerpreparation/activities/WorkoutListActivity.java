package ru.pavlenko.julia.summerpreparation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import ru.pavlenko.julia.summerpreparation.R;
import ru.pavlenko.julia.summerpreparation.list.WorkoutAdapter;

public class WorkoutListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private WorkoutAdapter workoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);
//        setContentView(R.layout.list_item);

        initGUI();
        addListeners();
    }

    private void initGUI() {
        recyclerView = findViewById(R.id.recycler_view);
        workoutAdapter = new WorkoutAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(workoutAdapter);
    }

    private void addListeners() {
    }
}

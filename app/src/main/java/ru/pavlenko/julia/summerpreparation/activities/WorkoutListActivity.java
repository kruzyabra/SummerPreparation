package ru.pavlenko.julia.summerpreparation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import ru.pavlenko.julia.summerpreparation.R;

public class WorkoutListActivity extends AppCompatActivity {
    ImageButton kettlebell;
    ImageButton bag;
    ImageButton barbell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);

        initGUI();
        addListeners();
    }

    private void initGUI() {
        kettlebell = findViewById(R.id.imageKettlebell);
        bag        = findViewById(R.id.imageBag);
        barbell    = findViewById(R.id.imageBarbell);
    }

    private void addListeners() {
        kettlebell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent workoutDetailIntent = new Intent(WorkoutListActivity.this, WorkoutDetailActivity.class);
                workoutDetailIntent.putExtra("name", "kettlebell");
                startActivity(workoutDetailIntent);
            }
        });
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent workoutDetailIntent = new Intent(WorkoutListActivity.this, WorkoutDetailActivity.class);
                workoutDetailIntent.putExtra("name", "bag");
                startActivity(workoutDetailIntent);
            }
        });
        barbell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent workoutDetailIntent = new Intent(WorkoutListActivity.this, WorkoutDetailActivity.class);
                workoutDetailIntent.putExtra("name", "barbell");
                startActivity(workoutDetailIntent);
            }
        });
    }
}

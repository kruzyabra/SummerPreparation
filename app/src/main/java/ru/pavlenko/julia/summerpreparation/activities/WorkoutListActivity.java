package ru.pavlenko.julia.summerpreparation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;

import ru.pavlenko.julia.summerpreparation.R;

public class WorkoutListActivity extends AppCompatActivity {
//    ImageButton kettlebell;
//    ImageButton bag;
//    ImageButton barbell;
    CardView dumbbell;
    ImageView shareButton;
    ImageView editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_workout_list);
        setContentView(R.layout.list_item);

        initGUI();
        addListeners();
    }

    private void initGUI() {
//        kettlebell = findViewById(R.id.imageKettlebell);
//        bag        = findViewById(R.id.imageBag);
//        barbell    = findViewById(R.id.imageBarbell);
        dumbbell    = findViewById(R.id.cardView);
        shareButton = findViewById(R.id.shareImageView);
        editButton  = findViewById(R.id.editImageView);
    }

    private void addListeners() {
//        kettlebell.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent workoutDetailIntent = new Intent(WorkoutListActivity.this, WorkoutDetailActivity.class);
//                workoutDetailIntent.putExtra("name", "kettlebell");
//                startActivity(workoutDetailIntent);
//            }
//        });
//        bag.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent workoutDetailIntent = new Intent(WorkoutListActivity.this, WorkoutDetailActivity.class);
//                workoutDetailIntent.putExtra("name", "bag");
//                startActivity(workoutDetailIntent);
//            }
//        });
//        barbell.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent workoutDetailIntent = new Intent(WorkoutListActivity.this, WorkoutDetailActivity.class);
//                workoutDetailIntent.putExtra("name", "barbell");
//                startActivity(workoutDetailIntent);
//            }
//        });
        dumbbell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent workoutDetailIntent = new Intent(WorkoutListActivity.this, WorkoutDetailActivity.class);
                workoutDetailIntent.putExtra("name", "barbell");
                startActivity(workoutDetailIntent);
            }
        });

//        shareButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String textMessage = "Lorem ipsum dolor sit amet, consectetur adipisicing elit.";
//
//                Intent sendMessageIntent = new Intent();
//                sendMessageIntent.setAction(Intent.ACTION_SEND);
//                sendMessageIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
//                sendMessageIntent.setType("text/plain");
//            }
//        });
    }
}

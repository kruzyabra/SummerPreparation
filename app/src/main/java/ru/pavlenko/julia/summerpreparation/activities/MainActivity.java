package ru.pavlenko.julia.summerpreparation.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import ru.pavlenko.julia.summerpreparation.R;
import ru.pavlenko.julia.summerpreparation.model.Workout;

public class MainActivity extends AppCompatActivity {
    Button   saveRecordButton;
    SeekBar  repeatSeekBar;
    EditText weightEditText;
    TextView dateTextView;
    TextView repeatTextView;
    TextView weightTextView;
    TextView repeatCounter;
    TextView title;
    Workout  workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveRecordButton = findViewById(R.id.saveRecordButton);
        repeatSeekBar    = findViewById(R.id.repeatSeekBar);
        weightEditText   = findViewById(R.id.weightEditText);
        dateTextView     = findViewById(R.id.dateValue);
        repeatTextView   = findViewById(R.id.repeatValue);
        weightTextView   = findViewById(R.id.weightValue);
        repeatCounter    = findViewById(R.id.repeatCounter);
        title            = findViewById(R.id.titleOfExercise);

        workout = new Workout("УПРАЖНЕНИЕ С ГРУШЕЙ", "Описание");
        initGUI(workout);
        addListeners();
    }

    private void initGUI(Workout workout) {
        title.setText(workout.getTitle());
        dateTextView.setText(new SimpleDateFormat("dd.MM.yyyy").format(workout.getRecordDate()));
        weightTextView.setText(String.valueOf(workout.getRecordWeight()));
        repeatTextView.setText(String.valueOf(workout.getRecordNumberOfReps()));
    }

    private void addListeners() {
        saveRecordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentRepeatValue = Integer.valueOf(repeatTextView.getText().toString());
                int currentWeightValue = Integer.valueOf(weightTextView.getText().toString());

                int newRepeatValue = repeatSeekBar.getProgress() * 5;
                int newWeightValue = Integer.valueOf(weightEditText.getText().toString());

                if (newRepeatValue > currentRepeatValue & newWeightValue >= currentWeightValue |
                        newWeightValue > currentWeightValue & newRepeatValue >= currentRepeatValue) {
                    repeatTextView.setText(String.valueOf(newRepeatValue));
                    workout.setRecordNumberOfReps(newRepeatValue);

                    weightTextView.setText(String.valueOf(newWeightValue));
                    workout.setRecordWeight(newWeightValue);

                    dateTextView.setText(new SimpleDateFormat("dd.MM.yyyy").format(new Date()));
                    workout.setRecordDate(new Date());
                }
            }
        });

        repeatSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                repeatCounter.setText(String.valueOf(repeatSeekBar.getProgress() * 5));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}

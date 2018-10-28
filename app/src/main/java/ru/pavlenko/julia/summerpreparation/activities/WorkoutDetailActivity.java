package ru.pavlenko.julia.summerpreparation.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ru.pavlenko.julia.summerpreparation.R;
import ru.pavlenko.julia.summerpreparation.model.Workout;

public class WorkoutDetailActivity extends AppCompatActivity {
    private static final String TAG = "WorkoutDetailActLog";
    private static final String KEY_REP = "numOfRep";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_DATE = "date";

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
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        String textMessage = "Инфа из мега-крутого приложения: ясделяль упражнение "
                + this.title.getText() + " аж "
                + repeatTextView.getText() + " раз с весом " + weightEditText.getText() + " чего-то там на дату " + dateTextView.getText();

        switch(id) {
            case R.id.share:
                Intent sendMessageIntent = new Intent();
                sendMessageIntent.setAction(Intent.ACTION_SEND);
                sendMessageIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
                sendMessageIntent.setType("text/plain");

                if(sendMessageIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendMessageIntent);
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate(Bundle) called");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_detail);

        saveRecordButton = findViewById(R.id.saveRecordButton);
        repeatSeekBar    = findViewById(R.id.repeatSeekBar);
        weightEditText   = findViewById(R.id.weightEditText);
        dateTextView     = findViewById(R.id.dateTextView);
        repeatTextView   = findViewById(R.id.repeatTextView);
        weightTextView   = findViewById(R.id.weightTextView);
        repeatCounter    = findViewById(R.id.repeatCounter);
        title            = findViewById(R.id.titleOfExercise);

//        Intent currentIntent = getIntent();
//        String type = currentIntent.getStringExtra("name");

        workout = new Workout("УПРАЖНЕНИЕ С ЧЕМ-ТО", "Описание");

//        switch(type) {
//            case "kettlebell":
//                workout = new Workout("УПРАЖНЕНИЕ С ГИРЕЙ", "Описание");
//                break;
//            case "bag":
//                workout = new Workout("УПРАЖНЕНИЕ С ГРУШЕЙ", "Описание");
//                break;
//            case "barbell":
//                workout = new Workout("УПРАЖНЕНИЕ СО ШТАНГОЙ", "Описание");
//                break;
//            default:
//                workout = new Workout("УПРАЖНЕНИЕ С ЧЕМ-ТО", "Описание");
//                break;
//        }

        if (savedInstanceState != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            try {
                workout.setRecordDate(format.parse(savedInstanceState.get(KEY_DATE).toString()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            workout.setRecordNumberOfReps(Integer.valueOf(savedInstanceState.get(KEY_REP).toString()));

            workout.setRecordWeight(Integer.valueOf(savedInstanceState.get(KEY_WEIGHT).toString()));
        }

        initGUI(workout);
        addListeners();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected  void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState called");

        outState.putString(KEY_DATE, dateTextView.getText().toString());
        outState.putString(KEY_REP, repeatTextView.getText().toString());
        outState.putString(KEY_WEIGHT, weightTextView.getText().toString());

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

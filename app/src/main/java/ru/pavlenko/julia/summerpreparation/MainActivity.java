package ru.pavlenko.julia.summerpreparation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button changeTextColorButton;
    Button changeEverythingButton;
    Button undoButton;
    ArrayList<Integer> colors = new ArrayList<>();
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createArrayOfColors();

        textView = findViewById(R.id.textView);
        changeTextColorButton = findViewById(R.id.changeTextColorButton);
        changeEverythingButton = findViewById(R.id.changeEverythingButton);
        undoButton = findViewById(R.id.undoButton);

        changeTextColorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setTextColor(getResources().getColor(getRandomColor()));
            }
        });

        changeEverythingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(getRandomLetterSequence(textView.getText().toString()));
                textView.setTextColor(getResources().getColor(getRandomColor()));
                changeTextColorButton.setText(getRandomLetterSequence(changeTextColorButton.getText().toString()));
                changeTextColorButton.setTextColor(getResources().getColor(getRandomColor()));
                changeEverythingButton.setTextColor(getResources().getColor(getRandomColor()));
            }
        });

        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(getResources().getText(R.string.text_view));
                changeTextColorButton.setText(getResources().getText(R.string.change_text_color_button));
                changeTextColorButton.setTextColor(getResources().getColor(R.color.colorBlack));
                changeEverythingButton.setTextColor(getResources().getColor(R.color.colorBlack));
            }
        });
    }

    private void createArrayOfColors() {
        colors.add(R.color.colorRed);
        colors.add(R.color.colorOrange);
        colors.add(R.color.colorYellow);
        colors.add(R.color.colorGreen);
        colors.add(R.color.colorBlue);
        colors.add(R.color.colorDarkBlue);
        colors.add(R.color.colorPurple);
    }

    private int getRandomColor() {
        int randomIndex = random.nextInt(colors.size() - 1);

        return colors.get(randomIndex);
    }

    private String getRandomLetterSequence(String text) {
        char[] stringToCharArray = text.toCharArray();
        text = "";

        for (int i = 0; i < stringToCharArray.length; i++) {
            int randomIndex = random.nextInt(stringToCharArray.length);

            char ch = stringToCharArray[i];
            stringToCharArray[i] = stringToCharArray[randomIndex];
            stringToCharArray[randomIndex] = ch;
        }

        for (int i = 0; i < stringToCharArray.length; i++) {
            text = text + stringToCharArray[i];
        }

        return text;
    }
}

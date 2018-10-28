package ru.pavlenko.julia.summerpreparation.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Workout {
    private String title;
    private String description;
    private int recordWeight;
    private int recordNumberOfReps;
    private Date recordDate;

    public Workout(String title, String description) {
        this.title = title;
        this.description = description;
        this.recordWeight = 0;
        this.recordNumberOfReps = 0;
        this.recordDate = new Date();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getRecordWeight() {
        return String.valueOf(recordWeight);
    }

    public String getRecordNumberOfReps() {
        return String.valueOf(recordNumberOfReps);
    }

    public String getRecordDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("DD.MM.yyyy");

        return simpleDateFormat.format(recordDate);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRecordWeight(int recordWeight) {
        this.recordWeight = recordWeight;
    }

    public void setRecordNumberOfReps(int recordNumberOfReps) {
        this.recordNumberOfReps = recordNumberOfReps;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }
}

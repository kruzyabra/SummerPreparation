package ru.pavlenko.julia.summerpreparation.model;

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

    public int getRecordWeight() {
        return recordWeight;
    }

    public int getRecordNumberOfReps() {
        return recordNumberOfReps;
    }

    public Date getRecordDate() {
        return recordDate;
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

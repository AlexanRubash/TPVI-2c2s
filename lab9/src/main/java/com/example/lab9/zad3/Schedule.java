package com.example.lab9.zad3;

public class Schedule {
    private int id;
    private int user_id;
    private int day_of_week;
    private String start_time;
    private String end_time;
    private String description;

    public Schedule() {}

    public Schedule(int user_id, int day_of_week, String start_time, String end_time, String description) {
        this.user_id = user_id;
        this.day_of_week = day_of_week;
        this.start_time = start_time;
        this.end_time = end_time;
        this.description = description;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getuser_id() {
        return user_id;
    }

    public void setuser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getday_of_week() {
        return day_of_week;
    }

    public void setday_of_week(int day_of_week) {
        this.day_of_week = day_of_week;
    }

    public String getstart_time() {
        return start_time;
    }

    public void setstart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getend_time() {
        return end_time;
    }

    public void setend_time(String end_time) {
        this.end_time = end_time;
    }


}


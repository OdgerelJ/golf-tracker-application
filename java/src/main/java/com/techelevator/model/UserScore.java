package com.techelevator.model;

import java.sql.Date;

public class UserScore {

    private int score;
    private String courseName;
    private Date golfDate;

    public UserScore() {
    }

    public UserScore(int score, String courseName, Date golfDate) {
        this.score = score;
        this.courseName = courseName;
        this.golfDate = golfDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getGolfDate() {
        return golfDate;
    }

    public void setGolfDate(Date golfDate) {
        this.golfDate = golfDate;
    }
}

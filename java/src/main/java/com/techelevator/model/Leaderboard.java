package com.techelevator.model;

import java.sql.Date;

public class Leaderboard {
    private String username;
    private int score;
    private String courseName;
    private Date golfDate;

    public Leaderboard(String username, int score, String courseName, Date golfDate) {
        this.username = username;
        this.score = score;
        this.courseName = courseName;
        this.golfDate = golfDate;
    }

    public Leaderboard() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

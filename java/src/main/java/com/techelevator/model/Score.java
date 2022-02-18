package com.techelevator.model;

import java.sql.Date;
import java.time.LocalDate;

public class Score {
    private int scoreId, userId, score, courseId, matchId;
    private LocalDate golfDate;
    private String courseName;

    public Score(int scoreId, int userId, int score, int courseId, int matchId, LocalDate golfDate, String courseName) {
        this.scoreId = scoreId;
        this.userId = userId;
        this.score = score;
        this.courseId = courseId;
        this.matchId = matchId;
        this.golfDate = golfDate;
        this.courseName = courseName;
    }

    //Entering course name
    public Score(int scoreId, int userId, int score, LocalDate golfDate, String courseName) {
        this.scoreId = scoreId;
        this.userId = userId;
        this.score = score;
        this.golfDate = golfDate;
        this.courseName = courseName;
    }
    //Entering course id
    public Score(int scoreId, int userId, int score, int courseId, LocalDate golfDate) {
        this.scoreId = scoreId;
        this.userId = userId;
        this.score = score;
        this.courseId = courseId;
        this.golfDate = golfDate;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", userId=" + userId +
                ", score=" + score +
                ", courseId=" + courseId +
                ", golfDate=" + golfDate +
                '}';
    }

    public Score() {
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getGolfDate() {
        return golfDate;
    }

    public void setGolfDate(LocalDate golfDate) {
        this.golfDate = golfDate;
    }
}

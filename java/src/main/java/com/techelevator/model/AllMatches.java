package com.techelevator.model;

public class AllMatches {
    private String leagueName, courseName, matchName, teeTime, userName;

    public AllMatches(String leagueName, String courseName, String matchName, String teeTime, String userName) {
        this.leagueName = leagueName;
        this.courseName = courseName;
        this.matchName = matchName;
        this.teeTime = teeTime;
        this.userName = userName;
    }

    public AllMatches() {
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getMatchName() {
        return matchName;
    }

    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }

    public String getTeeTime() {
        return teeTime;
    }

    public void setTeeTime(String teeTime) {
        this.teeTime = teeTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

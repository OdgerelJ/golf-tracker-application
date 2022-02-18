package com.techelevator.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class League {

    private int leagueId;
    @NotNull
    private String leagueName;
    @NotNull
    private int members;
    @NotNull
    private int courseId;

    public League(int leagueId, String leagueName, int members, int courseId) {
        this.leagueId = leagueId;
        this.leagueName = leagueName;
        this.members = members;
        this.courseId = courseId;
    }

    public League() {
    }

    @Override
    public String toString() {
        return "League{" +
                "leagueId=" + leagueId +
                ", leagueName='" + leagueName + '\'' +
                ", members=" + members +
                ", courseId=" + courseId +
                '}';
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}

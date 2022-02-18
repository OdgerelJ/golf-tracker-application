package com.techelevator.model;

public class UserLeague {

    private int leagueId;
    private int userId, member, courseId;
    private String league_name;

    public UserLeague() {
    }

    public UserLeague(int leagueId, int userId, int member, int courseId, String league_name) {
        this.leagueId = leagueId;
        this.userId = userId;
        this.member = member;
        this.courseId = courseId;
        this.league_name = league_name;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    @Override
    public String toString() {
        return "UserLeague{" +
                "leagueId=" + leagueId +
                ", userId=" + userId +
                ", member=" + member +
                ", courseId=" + courseId +
                ", league_name='" + league_name + '\'' +
                '}';
    }
}

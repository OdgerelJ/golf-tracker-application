package com.techelevator.model;


import java.sql.Timestamp;
import java.util.Arrays;

public class Match {
    private int matchId;
    private int leagueId;
    private int [] usersInMatch;
    private String matchName;
    private String teeTime;

    @Override
    public String toString() {
        return "Match{" +
                "matchId=" + matchId +
                ", leagueId=" + leagueId +
                ", usersInMatch=" + Arrays.toString(usersInMatch) +
                ", matchName='" + matchName + '\'' +
                ", teeTime='" + teeTime + '\'' +
                '}';
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int[] getUsersInMatch() {
        return usersInMatch;
    }

    public void setUsersInMatch(int[] usersInMatch) {
        this.usersInMatch = usersInMatch;
    }

    public Match(int matchId, String matchName, String teeTime) {
        this.matchId = matchId;
        this.matchName = matchName;
        this.teeTime = teeTime;

    }

    public Match() {
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
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
}

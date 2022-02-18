package com.techelevator.model;

public class UserMatch {
    private int userId, matchId;

    public UserMatch(int userId, int matchId) {
        this.userId = userId;
        this.matchId = matchId;
    }

    public UserMatch() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }
}

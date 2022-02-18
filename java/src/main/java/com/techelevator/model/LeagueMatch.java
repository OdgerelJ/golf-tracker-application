package com.techelevator.model;

public class LeagueMatch {
    private int leagueId;
    private int matchId;

    public LeagueMatch(int leagueId, int matchId) {
        this.leagueId = leagueId;
        this.matchId = matchId;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }
}

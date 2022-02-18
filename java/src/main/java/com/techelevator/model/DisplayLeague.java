package com.techelevator.model;

import java.util.Arrays;

public class DisplayLeague {
    private String name;
    private int numberOfPlayers;
    private String playerNames;
    private String courseName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getPlayerNames() {
        return playerNames;
    }

    public void setPlayerNames(String playerNames) {
        this.playerNames = playerNames;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public DisplayLeague() {
    }

    @Override
    public String toString() {
        return "DisplayLeague{" +
                "name='" + name + '\'' +
                ", numberOfPlayers=" + numberOfPlayers +
                ", playerNames='" + playerNames + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }

    public DisplayLeague(String name, int numberOfPlayers, String playerNames, String courseName) {
        this.name = name;
        this.numberOfPlayers = numberOfPlayers;
        this.playerNames = playerNames;
        this.courseName = courseName;
    }


}

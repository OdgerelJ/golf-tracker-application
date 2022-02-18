package com.techelevator.dao;


import com.techelevator.model.Match;
import com.techelevator.model.AllMatches;

import java.util.List;

public interface MatchDao {
    int create(String matchName, String teeTime);
    Match findByMatchName(String matchName) throws Exception;
    List<AllMatches> getUpcomingMatches();
}

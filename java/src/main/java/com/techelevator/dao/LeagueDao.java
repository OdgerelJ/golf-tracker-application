package com.techelevator.dao;

import com.techelevator.model.DisplayLeague;
import com.techelevator.model.League;
import com.techelevator.model.UserInLeague;

import java.util.List;

public interface LeagueDao {
    List<DisplayLeague> displayLeagues();
    int findIdByLeagueName(String leagueName);
    League getLeagueById(int leagueId);
    List<League> findAll();
    League findByLeagueName(String leagueName) throws Exception;
    int create(String leagueName, int members, int courseId);
    List<League> getLeagues();
    List<UserInLeague> getUserNameByLeagueId(int leagueId);
}

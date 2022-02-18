package com.techelevator.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.dao.LeagueDao;
import com.techelevator.model.DisplayLeague;
import com.techelevator.model.League;
import com.techelevator.model.UserInLeague;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController
public class LeagueController {
    @Autowired
    private LeagueDao leagueDao;

    public LeagueController(LeagueDao leagueDao) {
        this.leagueDao = leagueDao;
    }


    //need to remove course name from league
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/newLeague", method = RequestMethod.POST)
    public ResponseEntity<LeagueAddResponse> newLeague(@Valid @RequestBody League newLeague) {
        try {
            League league = leagueDao.findByLeagueName(newLeague.getLeagueName());
            throw new Exception();
        } catch (Exception e) {
            System.out.println(newLeague);
            int id = leagueDao.create(newLeague.getLeagueName(), newLeague.getMembers(), newLeague.getCourseId());
            System.out.println(id);
            return new ResponseEntity<>(new LeagueAddResponse(id), HttpStatus.CREATED);
        }
    }

    //ANDY'S
    @RequestMapping(path = "/allLeagues", method = RequestMethod.GET)
    public List<League> listLeague(){
        List<League> allLeagues = leagueDao.getLeagues();
        return allLeagues;
    }

    //Display League Page
    @RequestMapping(path = "/displayLeagues", method = RequestMethod.GET)
    public List<DisplayLeague> displayLeague(){
        List<DisplayLeague> allLeagues = leagueDao.displayLeagues();
        return allLeagues;
    }

    @RequestMapping(path = "/allPlayersName/{leagueId}", method = RequestMethod.GET)
    public List<UserInLeague> listPlayers(@PathVariable int leagueId){
        System.out.println(leagueId);
        List<UserInLeague> allPlayers = leagueDao.getUserNameByLeagueId(leagueId);
        System.out.println(allPlayers);
        return allPlayers;
    }
    //new endpoint for getting players name in the league
    //request parameter will be a league Id

    //to see what the response looks like
    static class LeagueAddResponse {

        private int id;

        LeagueAddResponse(int id) {
            this.id = id;
        }

        @JsonProperty("id")
        int getId() {
            return id;
        }

        void setId(int id) {
            this.id = id;
        }
    }
}

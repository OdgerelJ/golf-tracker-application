package com.techelevator.controller;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.dao.LeagueDao;
import com.techelevator.dao.MatchDao;
import com.techelevator.dao.UserMatchDao;
import com.techelevator.model.Match;
import com.techelevator.model.AllMatches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController
public class MatchController {
    @Autowired
    private MatchDao matchDao;

    public MatchController(MatchDao matchDao) {
        this.matchDao = matchDao;
    }

    @Autowired
    private UserMatchDao userMatchDao;
    @Autowired
    private LeagueDao leagueDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/newMatch", method = RequestMethod.POST)
    public void newMatch(@Valid @RequestBody Match newMatch) {
        //take information of match drop it into match table
        System.out.println(newMatch);


//        try {
//            Match match = matchDao.findByMatchName(newMatch.getMatchName());
//            throw new Exception();
//        } catch (Exception e) {
//            int id = matchDao.create(newMatch.getMatchName(), newMatch.getTeeTime());
//            return new ResponseEntity<>(new MatchAddResponse(id), HttpStatus.CREATED);
//        }
    }

@RequestMapping(path = "/upcomingMatches", method = RequestMethod.GET)
public List<AllMatches> upcomingMatchesList () {
        List<AllMatches> allUpcomingMatches = matchDao.getUpcomingMatches();
    System.out.println(allUpcomingMatches);
        return allUpcomingMatches;
}

//Need to make methods preventing creating match name duplicate


}

package com.techelevator.controller;

import com.techelevator.dao.ScoreDao;
import com.techelevator.model.Leaderboard;
import com.techelevator.model.Score;
import com.techelevator.model.UserScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class ScoreController {
    @Autowired
    private ScoreDao scoreDao;

    public ScoreController(ScoreDao scoreDao) {
        this.scoreDao = scoreDao;
    }

    @RequestMapping(path = "/allScores", method = RequestMethod.GET)
    public List<UserScore> listScores(){
        List<UserScore>allScores = scoreDao.getScores(); //Get all scores from the DB
        System.out.println("Getting all scores");
        System.out.println(allScores.size());
        return allScores; //return the data requested
    }

    @RequestMapping(path = "/userScores", method = RequestMethod.GET)
    public List<UserScore> getListUserScores(Principal principal){
        String name = principal.getName();
        Integer userId = scoreDao.findIdByUsername(name);
        List<UserScore> userScores = scoreDao.getScoresByUserId(userId);
        return userScores;
    }

    //this is for the NON LEAGUE SCORE
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value= "/newScore", method = RequestMethod.POST)
    public void newScore(@Valid @RequestBody Score newScore, Principal principal) { ;
        String name = principal.getName();
        Integer userId = scoreDao.findIdByUsername(name);
        scoreDao.create(userId, newScore.getScore(), newScore.getCourseId(), 1,newScore.getGolfDate() );
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value= "/newMatchScore", method = RequestMethod.POST)
    public void newMatchScore(@Valid @RequestBody Score newScore, Principal principal) {
        String name = principal.getName();
        Integer userId = scoreDao.findIdByUsername(name);
        scoreDao.create(userId, newScore.getScore(), newScore.getCourseId(), newScore.getMatchId(), newScore.getGolfDate() );
    }

    //leaderboard endpoint
    @RequestMapping(path = "/leaderboard", method = RequestMethod.GET)
    public List<Leaderboard> getLeaderboardScores(){
        List<Leaderboard>leaderboardScores = scoreDao.getLeaderboard(); //Get all scores from the DB
        return leaderboardScores; //return the data requested
    }

}

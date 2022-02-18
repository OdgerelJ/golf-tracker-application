package com.techelevator.controller;

import com.techelevator.dao.LeagueMatchDao;
import com.techelevator.model.LeagueMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController
public class LeagueMatchController {

    @Autowired
    private LeagueMatchDao leagueMatchDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value="/newLeagueMatch", method = RequestMethod.POST)
    public void newLeagueMatch(@Valid @RequestBody LeagueMatch leagueMatch) {
        leagueMatchDao.create(leagueMatch);
    }
}

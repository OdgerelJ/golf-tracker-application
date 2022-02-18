package com.techelevator.controller;

import com.techelevator.dao.UserLeagueDao;
import com.techelevator.model.League;
import com.techelevator.model.UserLeague;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController
public class UserLeagueController {

    @Autowired
    private UserLeagueDao userLeagueDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value= "/newUserLeague", method = RequestMethod.POST)
    public void newUserLeague(@Valid @RequestBody UserLeague userLeague) {
        userLeagueDao.create(userLeague);
    }



//Insert in
//
// need to get the leagueID and get UserId
}

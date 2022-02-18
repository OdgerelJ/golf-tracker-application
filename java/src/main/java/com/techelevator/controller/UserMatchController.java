package com.techelevator.controller;

import com.techelevator.dao.UserMatchDao;
import com.techelevator.model.UserMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController
public class UserMatchController {
    @Autowired
    private UserMatchDao userMatchDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value="/newUserMatch", method = RequestMethod.POST)
    public void newUserMatch(@Valid @RequestBody UserMatch userMatch) {
        userMatchDao.create(userMatch);
    }
}

package com.techelevator.dao;

import com.techelevator.model.UserLeague;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.PreparedStatement;

@Component
public class JdbcUserLeagueDao implements UserLeagueDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcUserLeagueDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);}

    @Override
    public boolean create(UserLeague userLeague) {

        boolean userLeagueCreated = false;
        String insertLeague = "Insert into users_leagues (user_id,league_id) values(?,?)";

        try{
            jdbcTemplate.update(insertLeague, userLeague.getUserId(), userLeague.getLeagueId());
        } catch(DataAccessException e) {
            return false;
        }
        return true;
    }
}

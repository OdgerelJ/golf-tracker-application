package com.techelevator.dao;

import com.techelevator.model.UserMatch;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcUserMatchDao implements UserMatchDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcUserMatchDao(DataSource dataSource)  {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean create(UserMatch userMatch) {
        boolean userMatchCreate = false;
        String insertUserMatch = "insert into users_matches (user_id, match_id) values(?,?)";
        try {
            jdbcTemplate.update(insertUserMatch, userMatch.getUserId(), userMatch.getMatchId());

        }catch (DataAccessException e) {
            return userMatchCreate;
        }
        return true;
    }

}

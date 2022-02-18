package com.techelevator.dao;

import com.techelevator.model.LeagueMatch;
import com.techelevator.model.Match;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcLeagueMatchDao implements LeagueMatchDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcLeagueMatchDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean create(LeagueMatch leagueMatch) {
        boolean leagueMatchCreated = false;
        String insertLeagueMatch = "insert into leagues_matches (league_id, match_id) values(?,?)";
        try {
            jdbcTemplate.update(insertLeagueMatch, leagueMatch.getLeagueId(), leagueMatch.getMatchId());
        } catch (DataAccessException e) {
            return leagueMatchCreated;
        }
        return true;
    }

}

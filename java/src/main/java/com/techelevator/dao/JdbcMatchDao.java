package com.techelevator.dao;

import com.techelevator.model.Match;
import com.techelevator.model.AllMatches;
import com.techelevator.model.UsersInUpcomingMatches;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMatchDao implements MatchDao{
    private JdbcTemplate jdbcTemplate;
    public JdbcMatchDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate((dataSource));
    }


    public int create(String matchName, String teeTime){
        int matchCreated = 0;
        String insertMatch = "insert into matches (match_name, tee_time) Values (?,?) returning match_id";
        matchCreated = jdbcTemplate.queryForObject(insertMatch, Integer.class, matchName, teeTime);

        return matchCreated;
    }


    @Override
    public Match findByMatchName(String matchName) throws Exception {
        for (Match match : this.findAll()) {
            if (match.getMatchName().toLowerCase().equals(matchName.toLowerCase())) {
                return match;
            }
        }
        throw new Exception("Match " + matchName + " was not found.");
    }

    public List<Match> findAll() {
        List<Match> matches = new ArrayList<>();
        String sql = "SELECT * from matches";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Match match = mapRowToMatch(results);
            matches.add(match);
        }
        return matches;
    }

    //NOT DONE YET
    @Override
    public List<AllMatches> getUpcomingMatches() {
        List<AllMatches> allMatchesArrayList = new ArrayList<>();
       String sql = "SELECT leagues.league_name, golf_courses.course_name, matches.match_name, tee_time, users.username\n" +
               "FROM matches\n" +
               "JOIN scores ON matches.match_id = scores.match_id\n" +
               "JOIN golf_courses ON scores.course_id = golf_courses.course_id\n" +
               "JOIN leagues ON golf_courses.course_id = leagues.course_id\n" +
               "JOIN users_leagues ON leagues.league_id = users_leagues.league_id\n" +
               "JOIN users ON users_leagues.user_id = users.user_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            allMatchesArrayList.add(mapRowToAllMatches(results));
        }
        return allMatchesArrayList;
    }

    private Match mapRowToMatch (SqlRowSet rs){
        Match match = new Match();
        return match;
    }

    private AllMatches mapRowToAllMatches(SqlRowSet rs) {
        AllMatches allMatches = new AllMatches();
        allMatches.setLeagueName(rs.getString("league_name"));
        allMatches.setMatchName(rs.getString("match_name"));
        allMatches.setCourseName(rs.getString("course_name"));
        allMatches.setUserName(rs.getString(("username")));
        allMatches.setTeeTime(rs.getString("tee_time"));
        return allMatches;
    }

    private UsersInUpcomingMatches mapRowToUsersInUpcomingMatches (SqlRowSet rs){
        UsersInUpcomingMatches usersInUpcomingMatches = new UsersInUpcomingMatches();
        usersInUpcomingMatches.setName(rs.getString("username"));
        return usersInUpcomingMatches;
    }

}

package com.techelevator.dao;

import com.techelevator.model.DisplayLeague;
import com.techelevator.model.League;
import com.techelevator.model.UserInLeague;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


@Service
public class JdbcLeagueDao implements LeagueDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcLeagueDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate; }

    @Override
    public int findIdByLeagueName(String leagueName) {
        return jdbcTemplate.queryForObject("select league_id from leagues where leagues =?", int.class, leagueName);
    }

    @Override
    public League getLeagueById(int leagueId) {
        String sql = "SELECT * FROM leagues WHERE league_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, leagueId);
        if(results.next()) {
            return mapRowToLeague(results);
        }else{
            throw new RuntimeException("leagueId " + leagueId+ " was not found.");
        }
    }

    @Override
    public List<League> findAll() {
        List<League> leagues = new ArrayList<>();
        String sql = "select * from leagues";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            League league = mapRowToLeague(results);
            leagues.add(league);
        }
        return leagues;
    }

    @Override
    public League findByLeagueName(String leagueName) throws Exception {
        for (League league : this.findAll()) {
            if (league.getLeagueName().toLowerCase().equals(leagueName.toLowerCase())) {
                return league;
            }
        }
        throw new Exception("League " + leagueName + " was not found.");
        }

    public List<DisplayLeague> displayLeagues(){
        List<DisplayLeague> displayLeagues = new ArrayList<>();
        String sql = "SELECT league_name, members, users.username, golf_courses.course_name " +
                "FROM leagues JOIN users_leagues ON leagues.league_id = users_leagues.league_id " +
                "JOIN users ON users_leagues.user_id = users.user_id " +
                "JOIN golf_courses ON leagues.league_id = golf_courses.course_id";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            DisplayLeague newDisplayLeague = mapRowToDisplayLeague(results);
            displayLeagues.add(newDisplayLeague);
        }
        return displayLeagues;
    }


    public int create(String leagueName, int members, int courseId){
        int leagueCreated = 0;

        String insertLeague = "insert into leagues (league_name,members,course_id) values(?,?,?) returning league_id";
        leagueCreated = jdbcTemplate.queryForObject(insertLeague, Integer.class, leagueName, members, courseId );

        return leagueCreated;

    }

    //it is not working on the postman with requested parameter is missing
    public List<UserInLeague> getUserNameByLeagueId(int leagueId) {
        String sql = "SELECT username FROM users " +
                "JOIN users_leagues ON users.user_id = users_leagues.user_id " +
                "JOIN leagues ON users_leagues.league_id = leagues.league_id " +
                "WHERE leagues.league_id = ?";
        List<UserInLeague> list = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, leagueId);
        while (results.next()) {
            list.add(mapRowToUserInLeague(results));
        }
        return list;
    }

    public List<League> getLeagues(){
        List<League> displayLeagues = new ArrayList<>();
//        String sql = "SELECT league_name, members, users.username, golf_courses.course_name " +
//                "FROM leagues JOIN users_leagues ON leagues.league_id = users_leagues.league_id " +
//                "JOIN users ON users_leagues.user_id = users.user_id " +
//                "JOIN golf_courses ON leagues.league_id = golf_courses.course_id";

        String sql = "SELECT * FROM leagues";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            League league = new League();
            league.setLeagueId( results.getInt("league_id"));
            league.setLeagueName(results.getString("league_name"));
            league.setMembers(results.getInt("members"));
            league.setCourseId(results.getInt("course_id"));
            displayLeagues.add(league);
        }
        return displayLeagues;
    }

    private UserInLeague mapRowToUserInLeague(SqlRowSet rs) {
        UserInLeague userInLeague = new UserInLeague();
        userInLeague.setName(rs.getString("username"));
        return userInLeague;
    }

    private League mapRowToLeague(SqlRowSet rs) {
        League league = new League();
        league.setLeagueId(rs.getInt("league_id"));
        league.setLeagueName(rs.getString("league_name"));
        league.setMembers(rs.getInt("members"));
        league.setCourseId(rs.getInt("course_id"));
        return league;
    }

    private DisplayLeague mapRowToDisplayLeague(SqlRowSet rs) {
        DisplayLeague displayLeague = new DisplayLeague();
        displayLeague.setName(rs.getString("league_name"));
        displayLeague.setCourseName(rs.getString("course_name"));
        displayLeague.setNumberOfPlayers(rs.getInt("members"));
        displayLeague.setPlayerNames(rs.getString("username"));
        return displayLeague;
    }

}

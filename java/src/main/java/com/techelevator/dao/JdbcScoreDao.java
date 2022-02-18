package com.techelevator.dao;

import com.techelevator.model.Leaderboard;
import com.techelevator.model.Score;
import com.techelevator.model.UserScore;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import javax.validation.Valid;
import java.security.Principal;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Component
public class JdbcScoreDao implements ScoreDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcScoreDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<UserScore> getScores() {
        List<UserScore> scores = new ArrayList<>();

        String sql = "SELECT users.username, score, golf_date FROM scores JOIN users ON users.user_id=scores.user_id ORDER BY score ASC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            scores.add(mapResultToUserScore(results));
        }
        return scores;
    }

    @Override
    public int findIdByUsername(String username) {

        String sql = "SELECT user_id FROM users WHERE username ILIKE ?";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, username);
        if (id != null) {
            return id;
        } else {
            return -1;
        }
    }

    @Override
    public List<UserScore> getScoresByUserId(int userId) {
        List<UserScore> scores = new ArrayList<>();
        String sql ="SELECT  score, golf_courses.course_name, golf_date FROM scores JOIN golf_courses ON scores.course_id=golf_courses.course_id JOIN users ON users.user_id=scores.user_id WHERE users.user_id = ? ORDER BY golf_date DESC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()){
            UserScore newScore = mapResultToUserScore(results);
            scores.add(newScore);
            }
        return scores;
    }

    //leaderboard functionality
    @Override
    public List<Leaderboard> getLeaderboard() {
        List<Leaderboard> scores = new ArrayList<>();
        String sql = "SELECT  users.username,score, golf_courses.course_name, golf_date FROM scores JOIN golf_courses ON scores.course_id=golf_courses.course_id JOIN users ON users.user_id=scores.user_id ORDER BY score ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            scores.add(mapResultToLeaderboard(results));
        }
        return scores;
    }

    @Override
    public boolean create(int userId, int score, int courseId, int matchId, LocalDate golfDate) {
        boolean scoreCreated = false;
        String insertScore = "insert into scores (user_id, score, course_id, match_id, golf_date) values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(insertScore, userId, score, courseId, matchId, golfDate);

        return scoreCreated;
    }


    private UserScore mapResultToUserScore (SqlRowSet rs){
        UserScore userScore = new UserScore();
        userScore.setScore(rs.getInt("score"));
        userScore.setCourseName(rs.getString("course_name"));
        userScore.setGolfDate(rs.getDate("golf_date"));
        return userScore;
    }
    private Leaderboard mapResultToLeaderboard (SqlRowSet rs){
        Leaderboard leaderboard = new Leaderboard();
        leaderboard.setUsername(rs.getString("username"));
        leaderboard.setScore(rs.getInt("score"));
        leaderboard.setCourseName(rs.getString("course_name"));
        leaderboard.setGolfDate(rs.getDate("golf_date"));
        return leaderboard;
    }

}

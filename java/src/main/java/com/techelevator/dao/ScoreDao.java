package com.techelevator.dao;

import com.techelevator.model.Leaderboard;
import com.techelevator.model.Score;
import com.techelevator.model.UserScore;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.security.Principal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface ScoreDao {

    List<UserScore> getScores();

    int findIdByUsername(String username);

    List<UserScore> getScoresByUserId(int userId);
    public List<Leaderboard> getLeaderboard();

    boolean create(int userId, int score, int courseId, int matchId, LocalDate golfDate);

}

package com.techelevator.dao;

import com.techelevator.model.GymLog;
import com.techelevator.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcGymLogDao implements GymLogDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcGymLogDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<GymLog> getAll() {
        List<GymLog> gymLogs = new ArrayList<>();
        try {
            String sql = "select * from gym_log";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
//            System.out.println(results.toString());
            while (results.next()) {
                GymLog gymLog = mapRowToGymLog(results);
                gymLogs.add(gymLog);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return gymLogs;
    }

    @Override
    public List<GymLog> getAllById(int userId) {
        List<GymLog> gymLogs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM gym_log " +
                    "WHERE user_id = ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                GymLog gymLog = mapRowToGymLog(results);
                gymLogs.add(gymLog);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return gymLogs;
    }

    @Override
    public void createGymLogEvent(GymLog gymLog) {
        try {
            String sql = "INSERT INTO gym_log (log_id, user_id, check_in, check_out, difference) " +
                    "VALUES (DEFAULT, ?, ?, ?, ?);";
            jdbcTemplate.update(sql, gymLog.getUserId(), gymLog.getCheckIn(), gymLog.getCheckOut(), gymLog.getDifference());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private GymLog mapRowToGymLog(SqlRowSet rs) {
        GymLog gymLog = new GymLog();
        gymLog.setLogId(rs.getInt("log_id"));
        gymLog.setUserId(rs.getInt("user_id"));
        gymLog.setCheckIn(rs.getTimestamp("check_in"));
        gymLog.setCheckOut(rs.getTimestamp("check_out"));
        gymLog.setDifference(rs.getInt("difference"));
        return gymLog;
    }
}

package com.techelevator.dao;

import com.techelevator.model.GymLog;
import com.techelevator.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcGymLogDao implements GymLogDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcGymLogDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createGymLogEvent(GymLog gymLog) {
        try {
            String sql = "INSERT INTO gym_log (log_id, user_id, check_in, check_out) " +
                    "VALUES (DEFAULT, ?, ?, ?);";
            jdbcTemplate.update(sql, gymLog.getUserId(), gymLog.getCheckIn(), gymLog.getCheckOut());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//    private Profile mapRowToGymLog(SqlRowSet rs) {
//        GymLog gymLog = new Profile();
//        profile.setProfileId(rs.getInt("profile_id"));
//        profile.setUserId(rs.getInt("user_id"));
//        profile.setName(rs.getString("name"));
//        profile.setEmail(rs.getString("email"));
//        profile.setGoals(rs.getString("goals"));
//        return profile;
//    }
}

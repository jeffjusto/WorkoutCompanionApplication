package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcProfileDao implements ProfileDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProfileDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Profile> findAll() {
        List<Profile> profiles = new ArrayList<>();
        try {
            String sql = "select * from profile";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            System.out.println(results.toString());
            while (results.next()) {
                Profile profile = mapRowToProfile(results);
                profiles.add(profile);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return profiles;
    }

//    @Override
//    public boolean createProfile(Profile profile) {
//        String insertProfileSql = "INSERT INTO profile (profile_id,user_id,name,email,goals) " +
//                "VALUES (DEFAULT,?,?,?,?)";
//        jdbcTemplate.update(insertProfileSql,profile.getUserId(),profile.getName(),profile.getEmail(),profile.getGoals());
//        SqlRowSet results = jdbcTemplate.queryForRowSet(insertProfileSql);
//        return true;
//    }

    @Override
    public boolean createProfile(Profile profile, int user_id) {
        String insertProfileSql = "Insert into profile(user_id)\n" +
                "Select user_id from users where user_id="+user_id;
        jdbcTemplate.queryForRowSet(insertProfileSql);
        return true;
    }

    private Profile mapRowToProfile(SqlRowSet rs) {
        Profile profile = new Profile();
        profile.setProfileId(rs.getInt("profile_id"));
        profile.setUserId(rs.getInt("user_id"));
        profile.setName(rs.getString("name"));
        profile.setEmail(rs.getString("email"));
        profile.setGoals(rs.getString("goals"));
        return profile;
    }
}

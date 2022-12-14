package com.techelevator.dao;

import com.techelevator.model.Profile;
import com.techelevator.model.User;
import org.jetbrains.annotations.NotNull;
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
            String sql = "SELECT * FROM profile";
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

    @Override
    public Profile findProfileById(int userId) {
        Profile profile = new Profile();
        try {
            String sql = "SELECT * FROM profile " +
                        "WHERE user_id = ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if (results.next()) {
                profile = mapRowToProfile(results);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return profile;
    }

    @Override
    public boolean createProfile(int userId) {
        String sql = "INSERT INTO profile (profile_id,user_id) " +
                "VALUES (DEFAULT,?);";
        jdbcTemplate.update(sql, userId);
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        return true;
    }

    @Override
    public boolean updateProfile(Profile profile) {
        try {
            String sql = "UPDATE profile " +
                    "SET name = ?, email = ?, goals = ? " +
                    "WHERE user_id = ?;" ;
            jdbcTemplate.update(sql, profile.getName(), profile.getEmail(), profile.getGoals(), profile.getUserId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean updateProfileImg(String profileImg, int userId) {
        try {
            String sql = "UPDATE profile " +
                    "SET profile_img = ? " +
                    "WHERE user_id = ?;" ;
            jdbcTemplate.update(sql, profileImg, userId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    private Profile mapRowToProfile(SqlRowSet rs) {
        Profile profile = new Profile();
        profile.setProfileId(rs.getInt("profile_id"));
        profile.setUserId(rs.getInt("user_id"));
        profile.setName(rs.getString("name"));
        profile.setEmail(rs.getString("email"));
        profile.setGoals(rs.getString("goals"));
        profile.setProfileImg(rs.getString("profile_img"));
        return profile;
    }
}

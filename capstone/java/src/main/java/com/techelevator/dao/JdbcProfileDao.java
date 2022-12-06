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
            String sql = "select profileid,userid,name,email,goals from profile";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Profile profile = mapRowToProfile(results);
                profiles.add(profile);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("check");
        return profiles;
    }

    @Override
    public boolean createProfile(Profile profile) {
        String insertProfileSql = "insert into profile (profileid,userid,name,email,goals) values (DEFAULT,?,?,?,?)";
        jdbcTemplate.update(insertProfileSql,profile.getProfileid(),profile.getUserid(),profile.getName(),profile.getEmail(),profile.getGoals());
        SqlRowSet results = jdbcTemplate.queryForRowSet(insertProfileSql);
        return true;
    }

    private Profile mapRowToProfile(SqlRowSet rs) {
        Profile profile = new Profile();
        profile.setProfileid(rs.getInt("profileid"));
        profile.setUserid(rs.getInt("userid"));
        profile.setName(rs.getString("name"));
        profile.setEmail(rs.getString("email"));
        profile.setGoals(rs.getString("goals"));
        return profile;
    }
}

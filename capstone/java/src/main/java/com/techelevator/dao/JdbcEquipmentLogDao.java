package com.techelevator.dao;

import com.techelevator.model.Equipment;
import com.techelevator.model.EquipmentLog;
import com.techelevator.model.GymLog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcEquipmentLogDao implements EquipmentLogDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcEquipmentLogDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createEntry(EquipmentLog equipmentLog) {
        try {
            String sql = "INSERT INTO equipment_log (entry_id, user_id, equipment_id, equipment_check_in, equipment_check_out, equipment_time_interval, weight,reps)" +
                    "VALUES (DEFAULT, ?, ?, ?, ?, ?, ?, ?);";
            jdbcTemplate.queryForRowSet(sql, equipmentLog.getUserId(), equipmentLog.getEquipmentId(), equipmentLog.getEquipmentCheckIn(),
                    equipmentLog.getEquipmentCheckOut(), equipmentLog.getEquipmentTimeInterval(), equipmentLog.getWeight(),
                    equipmentLog.getReps());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<EquipmentLog> getEntriesByUserId(int userId) {
        List<EquipmentLog> equipmentLogs = new ArrayList<>();
        try {
            String sql = "SELECT * FROM equipment_log " +
                    "WHERE user_id = ?;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                EquipmentLog equipmentLog = mapRowToEquipmentLog(results);
                equipmentLogs.add(equipmentLog);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return equipmentLogs;
    }

    private EquipmentLog mapRowToEquipmentLog (SqlRowSet rs){
        EquipmentLog equipmentLog = new EquipmentLog();
        equipmentLog.setEntryId(rs.getInt("entry_id"));
        equipmentLog.setUserId(rs.getInt("user_id"));
        equipmentLog.setEquipmentId(rs.getInt("equipment_id"));
        equipmentLog.setEquipmentCheckIn(rs.getTimestamp("equipment_check_in"));
        equipmentLog.setEquipmentCheckOut(rs.getTimestamp("equipment_check_out"));
        equipmentLog.setEquipmentTimeInterval(rs.getInt("equipment_time_interval"));
        equipmentLog.setWeight(rs.getInt("weight"));
        equipmentLog.setReps(rs.getInt("reps"));
        return equipmentLog;
    }
}

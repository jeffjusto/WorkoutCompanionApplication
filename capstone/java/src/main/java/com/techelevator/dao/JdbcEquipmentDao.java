package com.techelevator.dao;

import com.techelevator.model.Equipment;
import com.techelevator.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcEquipmentDao implements EquipmentDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcEquipmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Equipment> listAll() {
        List<Equipment> equipmentList = new ArrayList<>();
        try {
            String sql = "SELECT equipment_id, equipment_name, description, img_src, instruction_src " +
                    "FROM equipment;";
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            System.out.println(results.toString());
            while (results.next()) {
                Equipment equipment = mapRowToEquipment(results);
                equipmentList.add(equipment);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return equipmentList;
    }

    @Override
    public String getInstructionByEquipmentId(int equipmentId) {
        String instructions = "";
        try {
            String sql = "SELECT * " +
                    "FROM equipment " +
                    "WHERE equipment_id = ?;" ;
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, equipmentId);
            while (results.next()) {
                Equipment equipment = mapRowToEquipment(results);
                instructions = equipment.getInstructionSrc();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return instructions;
    };

    private Equipment mapRowToEquipment(SqlRowSet rs) {
        Equipment equipment = new Equipment();
        equipment.setId(rs.getInt("equipment_id"));
        equipment.setName(rs.getString("equipment_name"));
        equipment.setDescription(rs.getString("description"));
        equipment.setImgSrc(rs.getString("img_src"));
        equipment.setInstructionSrc(rs.getString("instruction_src"));
        return equipment;
    }
}

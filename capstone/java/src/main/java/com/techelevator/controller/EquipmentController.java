package com.techelevator.controller;

import com.techelevator.dao.EquipmentDao;
import com.techelevator.model.Equipment;
import com.techelevator.model.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class EquipmentController {

    private EquipmentDao equipmentDao;
    public EquipmentController(EquipmentDao equipmentDao) {
        this.equipmentDao = equipmentDao;
    }

    @RequestMapping(path = "/equipment", method = RequestMethod.GET)
    public List<Equipment> listAll() {
        return equipmentDao.listAll();
    }

    @RequestMapping(path = "/equipment/{equipmentId}/instruction", method = RequestMethod.GET)
    public String getInstructionByEquipmentId(@PathVariable int equipmentId) {
        return equipmentDao.getInstructionByEquipmentId(equipmentId);
    }


}

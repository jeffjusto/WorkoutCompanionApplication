package com.techelevator.controller;

import com.techelevator.dao.EquipmentDao;
import com.techelevator.model.Equipment;
import com.techelevator.model.Profile;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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


}

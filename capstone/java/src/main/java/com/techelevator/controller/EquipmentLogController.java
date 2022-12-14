package com.techelevator.controller;

import com.techelevator.dao.EquipmentLogDao;
import com.techelevator.model.EquipmentLog;
import com.techelevator.model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class EquipmentLogController {

    private EquipmentLogDao equipmentLogDao;

    public EquipmentLogController(EquipmentLogDao equipmentLogDao) {
        this.equipmentLogDao = equipmentLogDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/equipmentLog", method = RequestMethod.POST)
    public boolean createEntry(@RequestBody EquipmentLog equipmentLog) {
        try {
            equipmentLogDao.createEntry(equipmentLog);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return true;
    }
}

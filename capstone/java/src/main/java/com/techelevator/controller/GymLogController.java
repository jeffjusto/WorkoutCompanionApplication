package com.techelevator.controller;

import com.techelevator.dao.GymLogDao;
import com.techelevator.dao.JdbcGymLogDao;
import com.techelevator.model.GymLog;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class GymLogController {

    private JdbcGymLogDao dao;
    public GymLogController(JdbcGymLogDao dao) {
        this.dao = dao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/gymLog", method = RequestMethod.POST)
    public void createGymLogEvent(@RequestBody GymLog gymLog) {
        try {
            dao.createGymLogEvent(gymLog);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}

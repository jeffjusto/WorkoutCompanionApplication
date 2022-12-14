package com.techelevator.controller;

import com.techelevator.dao.GymLogDao;
import com.techelevator.dao.JdbcGymLogDao;
import com.techelevator.model.GymLog;
import com.techelevator.model.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class GymLogController {

    private JdbcGymLogDao dao;
    public GymLogController(JdbcGymLogDao dao) {
        try {
            this.dao = dao;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @RequestMapping(path = "/gymLog", method = RequestMethod.GET)
    public List<GymLog> getAll() { return dao.getAll();}

    @RequestMapping(path = "/gymLog/{userId}", method = RequestMethod.GET)
    public List<GymLog> getAllById(@PathVariable int userId) { return dao.getAllById(userId);}

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

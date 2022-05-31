package com.techelevator.controller;

import com.techelevator.dao.FamilyDao;
import com.techelevator.model.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class FamilyController {

    @Autowired
    private FamilyDao familyDao;

//    public FamilyController(FamilyDao familyDao) {
//        this.familyDao = familyDao;
//    }

    @RequestMapping(value = "/add-family", method = RequestMethod.POST)
    public void makeFamily(@RequestBody Family family) {
        familyDao.makeNewFamily(family);
    }




}

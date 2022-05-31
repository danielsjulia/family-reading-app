package com.techelevator.controller;

import com.techelevator.dao.FamilyDao;
import com.techelevator.model.Family;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class FamilyController {

    @Autowired
    private FamilyDao familyDao;

    public FamilyController(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    @ApiOperation("adding a family")
    @RequestMapping(path="/add-family", method = RequestMethod.POST)
    public Family makeFamily(@RequestBody @ApiParam("family object") Family family) {
        return familyDao.makeNewFamily(family);
    }

    @ApiOperation("getting a family")
    @RequestMapping(path="/{id}", method= RequestMethod.GET)
    public Family getFamily(@PathVariable @ApiParam("family id") Long id) {
        return familyDao.getFamilyById(id);
    }




}

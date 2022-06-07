package com.techelevator.controller;

import com.techelevator.dao.FamilyDao;
import com.techelevator.dao.PrizeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Prize;
import com.techelevator.model.ReadingLog;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class PrizeController {

    @Autowired
    private FamilyDao familyDao;
    @Autowired
    private PrizeDao prizeDao;
    @Autowired
    private UserDao userDao;

    @ApiOperation("adding a new Prize")
    @RequestMapping(path="/add-prize", method = RequestMethod.POST)
    public Prize addPrize(@RequestBody @ApiParam("Prize object") Prize prize) {

        return prizeDao.addPrize(prize);
    }


    @ApiOperation("get prize list by familyId")
    @RequestMapping(path="/family-prize", method = RequestMethod.GET)
    public List<Prize> getPrizeListByFamilyId(@ApiParam("Prize object") Principal principal) {

        int userId = userDao.findIdByUsername(principal.getName());
        int familyId = (int)familyDao.getFamilyIDByUserId((long)userId);

        return prizeDao.getListOfPrizes(familyId);
    }

}

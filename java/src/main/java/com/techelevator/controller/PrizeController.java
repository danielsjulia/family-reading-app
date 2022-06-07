package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.Member;
import com.techelevator.model.Prize;
import com.techelevator.model.PrizeUser;
import com.techelevator.model.ReadingLog;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
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
    @Autowired
    private MemberDao memberDao;

    @Autowired
    private PrizeUserDao prizeUserDao;

    @ApiOperation("adding a new Prize")
    @RequestMapping(path="/add-prize", method = RequestMethod.POST)
    public Prize addPrize(@RequestBody @ApiParam("Prize object") Prize prize,Principal principal) {

        Prize newPrize = prizeDao.addPrize(prize);

        int userId = userDao.findIdByUsername(principal.getName());
        long familyId = familyDao.getFamilyIDByUserId((long)userId);
        List<Member> members = memberDao.getMembers(familyId) ;

        PrizeUser prizeUser = new PrizeUser();

        for(Member member: members) {

            prizeUser.setPrize_id((int)newPrize.getPrizeId());
            prizeUser.setUser_id(member.getUserId().intValue());
            prizeUserDao.addPrizeUser(prizeUser);
        }

        return newPrize;
    }


    @ApiOperation("get prize list by familyId")
    @RequestMapping(path="/family-prize", method = RequestMethod.GET)
    public List<Prize> getPrizeListByFamilyId(@ApiParam("Prize object") Principal principal) {

        int userId = userDao.findIdByUsername(principal.getName());
        int familyId = (int)familyDao.getFamilyIDByUserId((long)userId);

        return prizeDao.getListOfPrizes(familyId);
    }

}

package com.techelevator.controller;

import com.techelevator.dao.FamilyDao;
import com.techelevator.dao.MemberDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Family;
import com.techelevator.model.Member;
import com.techelevator.model.RegisterMember;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
public class MemberController {

    @Autowired
    private FamilyDao familyDao;

    @Autowired
    private MemberDao memberDao;

//    @Autowired
//    private UserDao userDao;

//    public FamilyController(FamilyDao familyDao) {
//        this.familyDao = familyDao;
//    }

    @ApiOperation("adding a member")
    @RequestMapping(path="/myFamily/add-member", method = RequestMethod.POST)
    public Member addMember(@RequestBody @ApiParam("member object") Member member, Principal principal) {

        return memberDao.addMember(member);

    }

    // check for confirm password variable and the logic that checks it matches password.
    @ApiOperation("adding a new member")
    @RequestMapping(path="/myFamily/add-new-member", method = RequestMethod.POST)
    public void addNewMember(@RequestBody @ApiParam("member object") RegisterMember registerMember) {
        System.out.println(registerMember);
        memberDao.registerNewMember(registerMember);
    }

}

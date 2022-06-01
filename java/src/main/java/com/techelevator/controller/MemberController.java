package com.techelevator.controller;

import com.techelevator.dao.FamilyDao;
import com.techelevator.dao.MemberDao;
import com.techelevator.model.Family;
import com.techelevator.model.Member;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

public class MemberController {

    @Autowired
    private FamilyDao familyDao;

    @Autowired
    private MemberDao memberDao;

//    public FamilyController(FamilyDao familyDao) {
//        this.familyDao = familyDao;
//    }

    @ApiOperation("adding a member")
    @RequestMapping(path="/myFamily/add-member", method = RequestMethod.POST)
    public Member addMember(@RequestBody @ApiParam("member object") Member member, Principal principal) {

        return memberDao.addMember(member);

    }

    @ApiOperation("getting a family")
    @RequestMapping(path="/{id}", method= RequestMethod.GET)
    public Family getFamily(@PathVariable @ApiParam("family id") Long id) {
        return familyDao.getFamilyById(id);
    }

}

package com.techelevator.dao;

import com.techelevator.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcMemberDao implements MemberDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Member getMemberById(Long id) {
        return null;
    }

    @Override
    public Member addMember(Member member) {

        Long user_id ;


        String sql = "INSERT INTO family_member(user_id, family_id, is_Parent) " +
                "VALUES(?, ?, ? ) " +
                "RETURNING user_id ;";

        user_id = jdbcTemplate.queryForObject(sql
                , long.class
                , member.getUserId()
                ,member.getFamilyId()
                ,member.isParent());

        if(user_id != null ) return member;
        else return null;

    }


}

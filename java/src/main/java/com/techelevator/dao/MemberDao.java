package com.techelevator.dao;

import com.techelevator.model.Member;
import com.techelevator.model.RegisterMember;

public interface MemberDao {

    public Member getMemberById(Long id);

    public Member addMember(Member member);

    public void registerNewMember(RegisterMember registerMember);

}

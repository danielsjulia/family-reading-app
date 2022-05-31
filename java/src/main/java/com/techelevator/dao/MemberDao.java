package com.techelevator.dao;

import com.techelevator.model.Member;

public interface MemberDao {

    public Member getMemberById(Long id);

    public boolean addMember(Member member);

}

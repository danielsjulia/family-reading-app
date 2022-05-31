package com.techelevator.dao;

import com.techelevator.model.Family;

public interface FamilyDao {

    String getFamilyNameByFamilyId(Long familyId);

    Long getFamilyIdByFamilyName(String name);

    Family makeNewFamily(Family newFam, String userName);

    Family getFamilyById(Long familyId);

//    List<Members> getFamilyMembersByFamilyId(Long familyId);
    // sql statement
    //
}

package com.techelevator.model;

import java.util.List;

public class Family {

    private Long familyId;
    private String familyName;
//    private boolean isParent;

//    private List<>

    public Family(Long familyId, String familyName) {
        this.familyId = familyId;
        this.familyName = familyName;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}

package com.techelevator.model;

import java.util.Date;

public class Prize {

    private long prizeId;
    private String name;
    private String description;
    private Date start_date;
    private Date end_date;
    private int milestone; //minutes
    private  boolean isActive;
    private int numberOfWinners;

    public Prize() {
    }

    public Prize(long prizeId, String name, String description, Date start_date, Date end_date, int milestone, boolean isActive, int numberOfWinners) {
        this.prizeId = prizeId;
        this.name = name;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.milestone = milestone;
        this.isActive = isActive;
        this.numberOfWinners = numberOfWinners;
    }

    public long getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(long prizeId) {
        this.prizeId = prizeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getMilestone() {
        return milestone;
    }

    public void setMilestone(int milestone) {
        this.milestone = milestone;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean active) {
        isActive = active;
    }

    public int getNumberOfWinners() {
        return numberOfWinners;
    }

    public void setNumberOfWinners(int numberOfWinners) {
        this.numberOfWinners = numberOfWinners;
    }
}

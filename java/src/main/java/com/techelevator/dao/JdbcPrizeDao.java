package com.techelevator.dao;

import com.techelevator.model.Prize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPrizeDao implements PrizeDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Prize addPrize(Prize prize) {
        Long prizeId ;

        String sql = "INSERT INTO prize(prize_name, description,start_date," +
                "end_date, milestone,isActive ,numberOfWinners) " +
                "VALUES(?, ?, ? , ?, ?, ?, ?) " +
                "RETURNING prize_id ;";

       prizeId = jdbcTemplate.queryForObject(sql
                , long.class
                ,prize.getName()
               ,prize.getDescription()
               ,prize.getStartDate()
               ,prize.getEndDate()
               ,prize.getMilestone()
               ,prize.getIsActive()
               ,prize.getNumberOfWinners());

       return getPrizeByPrizeId((prizeId));


    }



    @Override
    public List<Prize> getListOfPrizes(long familyId) {
        List<Prize> prizes = new ArrayList<>();

        String sql = "SELECT p.prize_id, p.prize_name, p.description, p.start_date," +
                " p.end_date, p.milestone,p.isActive ,p.numberOfWinners From Prize  as  p " +
                "JOIN prize_user as pu ON p.prize_id = pu.prize_id "+
                "JOIN family_member as fm ON pu.user_id = fm.user_id "+
                "Where  fm.family_id = ? ;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, familyId);

        while(rowSet.next()){
            Prize prize = new Prize();
            prize = rowToMapPrize((rowSet));
            prizes.add(prize);
        }


        return prizes;
    }

    @Override
    public Prize getPrizeByPrizeId(long prizeId) {
       Prize prize = new Prize();

        String sql = "SELECT prize_id, prize_name, description,start_date," +
                " end_date, milestone,isActive, numberOfWinners From Prize Where prize_id = ?;";

        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, prizeId);

        if(rowSet.next()) {
            prize = rowToMapPrize(rowSet);
        }


        return prize;
    }

    private Prize rowToMapPrize(SqlRowSet sqlRowSet) {

        Prize prize = new Prize();

        prize.setPrizeId(sqlRowSet.getLong("prize_id"));
        prize.setName(sqlRowSet.getString("prize_name"));
        prize.setDescription(sqlRowSet.getString("description"));
        prize.setStartDate(sqlRowSet.getDate("start_date"));
        prize.setEndDate(sqlRowSet.getDate("end_date"));
        prize.setMilestone(sqlRowSet.getInt("milestone"));
        prize.setIsActive(sqlRowSet.getBoolean("isActive"));
        prize.setNumberOfWinners(sqlRowSet.getInt("numberOfWinners"));

        //number of prizes per month

        return prize;
    }

}

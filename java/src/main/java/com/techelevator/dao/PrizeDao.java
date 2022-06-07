package com.techelevator.dao;

import com.techelevator.model.Member;
import com.techelevator.model.Prize;

import java.util.List;

public interface PrizeDao {
   Prize addPrize(Prize prize);
   List<Prize> getListOfPrizes(long familyId);
   Prize getPrizeByPrizeId(long prizeId);
   List<Member> getWinners(int prizeId, int familyId);
}

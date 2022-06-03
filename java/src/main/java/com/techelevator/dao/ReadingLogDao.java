package com.techelevator.dao;

import com.techelevator.model.ReadingLog;

import java.util.List;

public interface ReadingLogDao {

    ReadingLog getReadingLogById(int logId);

    List<ReadingLog> getReadingLogByUserId(int userId);

    List<ReadingLog> getReadingLogByFamilyId(int familyId);

    ReadingLog addNewReadingLog(ReadingLog readingLog);

}

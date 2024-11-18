package com.deployment.kubectl.service;

import com.deployment.kubectl.entity.RecordEntity;

import java.util.List;

public interface RecordService {
    RecordEntity saveRecord(RecordEntity recordEntity);
    List<RecordEntity> getAllRecords();

    RecordEntity getRecord(int idNumber);

    String deleteRecord(int idNumber);
}

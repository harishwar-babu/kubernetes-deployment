package com.deployment.kubectl.repository;

import com.deployment.kubectl.entity.RecordEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RecordRepositoryImpl implements RecordRepository {
    private  List<RecordEntity> recordEntityList;
    public RecordRepositoryImpl(){
        recordEntityList=new ArrayList<>();
    }
    @Override
    public RecordEntity save(RecordEntity recordEntity) {
        recordEntityList.add(recordEntity);
        return recordEntity;
    }

    @Override
    public List<RecordEntity> findAll() {
        return recordEntityList;
    }

    @Override
    public boolean existsByIdNumber(int idNumber) {
        return recordEntityList.stream().anyMatch(recordEntity -> recordEntity.getIdNumber()==idNumber);
    }

    @Override
    public void deleteRecordEntity(int idNumber) {
        recordEntityList=recordEntityList.stream().filter(recordEntity -> recordEntity.getIdNumber()!=idNumber).toList();
    }

    @Override
    public Optional<List<RecordEntity>> findByIdNumber(int idNumber) {
        return Optional.of(recordEntityList.stream().filter(recordEntity -> recordEntity.getIdNumber()==idNumber).toList());
    }
}

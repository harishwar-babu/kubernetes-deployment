package com.deployment.kubectl.repository;
import com.deployment.kubectl.entity.RecordEntity;
import java.util.List;
import java.util.Optional;

public interface RecordRepository {
    RecordEntity save(RecordEntity recordEntity);
    List<RecordEntity> findAll();

    boolean existsByIdNumber(int idNumber);

    void deleteRecordEntity(int idNumber);

    Optional<List<RecordEntity>> findByIdNumber(int idNumber);

}

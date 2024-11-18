package com.deployment.kubectl.serviceimpl;
import com.deployment.kubectl.entity.RecordEntity;
import com.deployment.kubectl.repository.RecordRepository;
import com.deployment.kubectl.service.RecordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class RecordServiceImpl implements RecordService {
    private final RecordRepository recordRepository;
    @Override
    public RecordEntity saveRecord(RecordEntity recordEntity) {
        return recordRepository.save(recordEntity);
    }

    @Override
    public List<RecordEntity> getAllRecords() {
        return recordRepository.findAll();
    }

    @Override
    public RecordEntity getRecord(int idNumber) {
        return recordRepository.findByIdNumber(idNumber).orElseThrow(()->new NoSuchElementException("Record Doesn't exists")).get(0);
    }

    @Override
    public String deleteRecord(int idNumber) {
        if(!recordRepository.existsByIdNumber(idNumber)){
            throw new NoSuchElementException("Record Doesn't exists");
        }
        recordRepository.deleteRecordEntity(idNumber);
        return "Deleted";
    }
}

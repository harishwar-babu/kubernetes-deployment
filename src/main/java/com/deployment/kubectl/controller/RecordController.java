package com.deployment.kubectl.controller;
import com.deployment.kubectl.entity.RecordEntity;
import com.deployment.kubectl.service.RecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@AllArgsConstructor
public class RecordController {
    private final RecordService recordService;
    @PostMapping("/save")
    public ResponseEntity<RecordEntity> saveRecord(@RequestBody RecordEntity recordEntity){
        return ResponseEntity.status(HttpStatus.CREATED).body(recordService.saveRecord(recordEntity));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<RecordEntity>> getAllRecords(){
        return ResponseEntity.ok(recordService.getAllRecords());
    }
    @GetMapping("/get/{idNumber}")
    public ResponseEntity<RecordEntity> getRecord(@PathVariable int idNumber){
        return ResponseEntity.ok(recordService.getRecord(idNumber));
    }
    @DeleteMapping("/delete/{idNumber}")
    public ResponseEntity<String> deleteRecord(@PathVariable int idNumber){
        return ResponseEntity.ok(recordService.deleteRecord(idNumber));
    }
}

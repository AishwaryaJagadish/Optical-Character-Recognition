package com.medicalrecordet.ETMedicalRecord.controller;

import com.medicalrecordet.ETMedicalRecord.model.DbSequence;
import com.medicalrecordet.ETMedicalRecord.model.InvoiceRecord;
import com.medicalrecordet.ETMedicalRecord.repository.DbRepo;
import com.medicalrecordet.ETMedicalRecord.repository.InvoiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private InvoiceRepo repo;

    @Autowired
    private DbRepo  dbRepo;

    @PostMapping("/invoicerecord")
    public ResponseEntity<?> insertrecord(@RequestBody InvoiceRecord record){
        DbSequence db = dbRepo.findById("seq").get();
        db.setSeq(db.getSeq()+1);
        dbRepo.save(db);
        record.setId(db.getSeq());
        repo.save(record);
        return new ResponseEntity<>("Invoice added to database with the id: "+record.getId(), HttpStatus.OK);
    }

    @GetMapping("/invoicerecord/{invoiceNumber}")
    public ResponseEntity<?> findbyid(@PathVariable String invoiceNumber){
        List<InvoiceRecord> record=repo.findByInvoice(invoiceNumber);
            return new ResponseEntity<List<InvoiceRecord>>(record, HttpStatus.OK);
    }
}

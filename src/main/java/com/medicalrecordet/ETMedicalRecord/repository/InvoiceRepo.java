package com.medicalrecordet.ETMedicalRecord.repository;

import com.medicalrecordet.ETMedicalRecord.model.InvoiceRecord;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface InvoiceRepo extends MongoRepository<InvoiceRecord, Integer> {

    @Query("{'invoiceNumber': ?0}")
    List<InvoiceRecord> findByInvoice(String invoiceNumber);
}

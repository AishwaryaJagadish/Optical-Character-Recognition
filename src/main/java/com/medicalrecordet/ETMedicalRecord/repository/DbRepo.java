package com.medicalrecordet.ETMedicalRecord.repository;


import com.medicalrecordet.ETMedicalRecord.model.DbSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DbRepo extends MongoRepository<DbSequence, String> {
}

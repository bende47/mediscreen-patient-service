package com.mediscreen.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mediscreen.entities.Patient;

public interface PatientRepository  extends MongoRepository<Patient, String>{
}

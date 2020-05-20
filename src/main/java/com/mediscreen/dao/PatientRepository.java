package com.mediscreen.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.mediscreen.entities.Patient;

@Repository
public interface PatientRepository  extends MongoRepository<Patient, String>{
	@Query("{ 'name' : ?0 },{ 'firstname' : ?0 },{ 'phone' : ?0 }")
	Patient findByPatient(String name, String firstname,String phone);
}

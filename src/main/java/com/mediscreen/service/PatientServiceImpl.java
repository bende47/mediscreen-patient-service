package com.mediscreen.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediscreen.dao.PatientRepository;
import com.mediscreen.entities.Patient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService{
	

	
	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public Patient addPatient(Patient p) {	
		
		Patient patient = patientRepository.findByPatient(p.getName(), p.getFirstname(),p.getPhone());
		
		if(patient == null) {
			p.setDateCreate(new Date());
			log.info("Patient ajouté avec succès:" + p.toString());
			p = patientRepository.save(p); 
			return p;
		}else {
			return patient;
		}

	}

	@Override
	public List<Patient> allPatient() {		
		return patientRepository.findAllByOrderByIdDesc();
	}

	@Override
	public Patient updatePatient(Patient p,String id) {
		Patient patient = patientRepository.findPatientById(id);
		if(patient != null) {
			patient.setDateUpdate(new Date());
			patient.setAddress(p.getAddress());
			patient.setBirthday(p.getBirthday());
			patient.setFirstname(p.getFirstname());
			patient.setName(p.getName());
			patient.setPhone(p.getPhone());
			patient.setSex(p.getSex());
			patientRepository.save(patient);
			log.info("Patient modififé avec succès:" + patient.toString());

		}
		return patient;
	}

	@Override
	public void deletePatient(String id) {		
		Patient patient = patientRepository.findPatientById(id);
		patientRepository.delete(patient);
		log.info("Patient supprimé avec succès");

	}

	@Override
	public Patient findPatient(String id) {
		Patient patient = patientRepository.findPatientById(id);
		log.info("Patient ="+patient.toString());
		return patient;
	}
	
	

}

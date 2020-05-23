package com.mediscreen.service;

import java.time.LocalDate;
import java.util.Calendar;
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
	
	private  Calendar calendar = Calendar.getInstance();

	
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
			return null;
		}

	}

	@Override
	public List<Patient> allPatient() {		
		return patientRepository.findAllByOrderByIdDesc();
	}

	@Override
	public Patient updatePatient(Patient p,String id) {
		Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient introuvable:" + id));
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
		Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient introuvable:" + id));
		patientRepository.delete(patient);
		log.info("Patient supprimé avec succès");

	}

	@Override
	public Patient findPatient(String id) {
		Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient introuvable:" + id));
		log.info("Patient ="+patient.toString());
		return patient;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public int determineAge(LocalDate date) {
		/*Determiner l'annee */
		int annee=date.getYear();
		int calannee=calendar.get(Calendar.YEAR)-annee;
		
		/*Determiner le mois*/
		int mois=date.getMonthValue();
		int calmois=calendar.MONTH - mois;			

		if (calmois >= 0) {
			log.info("age = {}", calannee);
			return calannee;
		} else {
			log.info("age = {}", calannee - 1);
			return calannee - 1;
		}
	}

}

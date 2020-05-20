package com.mediscreen.service;

import java.util.List;

import com.mediscreen.entities.Patient;

public interface PatientService {
	
	/**
	 * 
	 * @param p
	 * @return patient
	 * Ajouter les informations d'un patient
	 */
	public Patient addPatient(Patient p);
	
	/**
	 * 
	 * @param id
	 * 
	 * Rechercher un patient a partir de son id
	 */
	public Patient findPatient(String id);
	
	
	/**
	 * 
	 * @return Liste des patients
	 */
	public List<Patient> allPatient();
	
	/**
	 * 
	 * @param p
	 * @param id
	 * @return les informations du Patient modifiées
	 */
	public Patient updatePatient(Patient p,String id);
	
	/**
	 * 
	 * @param id
	 * 
	 * Suppression du patient
	 */
	public void deletePatient(String id);
	
	

}

package com.mediscreen;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.mediscreen.dao.PatientRepository;
import com.mediscreen.entities.Patient;

@SpringBootTest
@TestPropertySource(locations="classpath:bootstrap.properties")
public class PatientServiceTest {

	@Autowired
	private PatientRepository patientRepository;
	
	SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");	
	
	private static Patient patient;
	
	@BeforeAll
	public static void setup() {
		   patient = new Patient("Test", "TestPrenoms", "F", new Date(), "17 rue de Test", "33751458525");
	}
	
	@Test
	public void addPatientTest(){		
	  patient = patientRepository.save(patient);
	  assertEquals("Test", patient.getName());
	  assertEquals("TestPrenoms", patient.getFirstname());
	}
	
	@Test
	public void allPatientTest(){
      patient = patientRepository.save(patient);
	  List<Patient> listP = patientRepository.findAll();
	  assertTrue(listP.size() >0 );
	}
	
	@Test
	public void updatePatientTest(){
	  patient.setAddress("74 rue des bienevenus"); 
      patient = patientRepository.save(patient);
	  assertEquals("74 rue des bienevenus", patient.getAddress());
	}
	
	@Test
	public void findPatientTest(){
	  patient = patientRepository.save(patient);
	  String id = patient.getId();
	  Optional<Patient> patient = patientRepository.findById(id);
	  assertTrue(patient.isPresent());
	}
	
	@Test
	public void deletePatientTest(){
	  patient = patientRepository.save(patient);
	  String id = patient.getId();
	  patientRepository.delete(patient);
	  Optional<Patient> patient = patientRepository.findById(id);
	  assertFalse(patient.isPresent());
	}
	

}

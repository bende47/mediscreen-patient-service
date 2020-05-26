package com.mediscreen;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PatientServiceControllerTest {

	@Autowired
	private MockMvc mvc;	
	
	@Test
	public void addPatientTestC() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.post("/patient/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\": \"test1\",\"name\": \"Test1\",\"firstname\": \"Test2\",\"sex\": \"F\",\"birthday\": \"1973-10-01\",\"address\": \"12 rue plateau\",\"phone\": \"22547080680\"}")
				.accept(MediaType.APPLICATION_JSON))
		        .andDo(MockMvcResultHandlers.print())
		        .andExpect(status().isOk());

	}	
	
	@Test
	public void findPatientTestC() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/patient/find/test3")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());

	}
	
	@Test
	public void allPatientTestC() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.get("/patient/all")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());

	}
	
	@Test
	public void updatePatientTestC() throws Exception {
		this.mvc.perform(MockMvcRequestBuilders.post("/patient/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\": \"test3\",\"name\": \"Test3\",\"firstname\": \"Test3\",\"sex\": \"F\",\"birthday\": \"1973-10-03\",\"address\": \"13 rue plateau\",\"phone\": \"22547080683\"}")
				.accept(MediaType.APPLICATION_JSON))
		        .andDo(MockMvcResultHandlers.print())
		        .andExpect(status().isOk());
		
		this.mvc.perform(MockMvcRequestBuilders.put("/patient/update/test3")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"name\": \"Test3\",\"firstname\": \"Test3\",\"sex\": \"F\",\"birthday\": \"1973-10-01\",\"address\": \"12 rue plateau\",\"phone\": \"22547080680\"}")
				.accept(MediaType.APPLICATION_JSON))
		        .andDo(MockMvcResultHandlers.print())
		        .andExpect(status().isOk());

	}
	
	
	@Test
	public void deletePatientTestC() throws Exception {
		
		this.mvc.perform(MockMvcRequestBuilders.post("/patient/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\": \"test3\",\"name\": \"Test3\",\"firstname\": \"Test3\",\"sex\": \"F\",\"birthday\": \"1973-10-03\",\"address\": \"13 rue plateau\",\"phone\": \"22547080683\"}")
				.accept(MediaType.APPLICATION_JSON))
		        .andDo(MockMvcResultHandlers.print())
		        .andExpect(status().isOk());
		
		this.mvc.perform(MockMvcRequestBuilders.delete("/patient/delete/test3")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());

	}
	

}

package com.mediscreen.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Patient {

	@Id
	private String id;
	private String name;
	private String firstname;
	private String sex;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private String address;
	private String phone;
	private Date dateCreate;
	private Date dateUpdate;	
	
}

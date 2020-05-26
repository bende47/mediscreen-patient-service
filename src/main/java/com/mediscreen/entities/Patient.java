package com.mediscreen.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Patient {

	@Id
	private String id;
	private String name;
	private String firstname;
	private String sex;
	private Date birthday;
	private String address;
	private String phone;
	private Date dateCreate;
	private Date dateUpdate;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday!= null ? (Date) birthday.clone() : null;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday != null ? new Date(birthday.getTime()) : null;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the dateCreate
	 */
	public Date getDateCreate() {
		return dateCreate!= null ? (Date) dateCreate.clone() : null;
	}
	/**
	 * @param dateCreate the dateCreate to set
	 */
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate != null ? new Date(dateCreate.getTime()) : null;
	}
	/**
	 * @return the dateUpdate
	 */
	public Date getDateUpdate() {
		return dateUpdate!= null ? (Date) dateUpdate.clone() : null;
	}
	/**
	 * @param dateUpdate the dateUpdate to set
	 */
	public void setDateUpdate(Date dateUpdate) {
		this.dateUpdate = dateUpdate != null ? new Date(dateUpdate.getTime()) : null;
	}
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 * @param firstname
	 * @param sex
	 * @param birthday
	 * @param address
	 * @param phone
	 */
	public Patient(String name, String firstname, String sex, Date birthday, String address, String phone) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.sex = sex;
		this.birthday = birthday != null ? new Date(birthday.getTime()) : null;
		this.address = address;
		this.phone = phone;
	}	
	
	
	
	
}

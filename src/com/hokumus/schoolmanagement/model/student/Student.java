package com.hokumus.schoolmanagement.model.student;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hokumus.schoolmanagement.model.util.BaseEntity;

@Entity
public class Student extends BaseEntity {
	private Long id;
	private String name;
	private String surname;
	private String adress;
	private String phone;
	private String email;
	private Date registerdate;
	private GenderEnums gender;

	@SequenceGenerator(name = "seq_student_id",initialValue = 1,allocationSize = 1,sequenceName = "seq_student_id")
	@GeneratedValue(generator ="seq_student_id" ,strategy = GenerationType.SEQUENCE )
	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	public Date getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}

	@Enumerated
	public GenderEnums getGender() {
		return gender;
	}

	public void setGender(GenderEnums gender) {
		this.gender = gender;
	}

}

package com.hokumus.schoolmanagement.model.teacher;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.hokumus.schoolmanagement.model.util.BaseEntity;

@Entity
public class Teacher extends BaseEntity{

	private Long id;
	private String name;
	private String surname;
	private String adress;
	private String phone;
	private String email;
	private BigDecimal salary;
	private Date memberdate;

	@Id
    @SequenceGenerator(name = "seq_teacher", allocationSize = 1, sequenceName = "seq_teacher")
    @GeneratedValue(generator = "seq_teacher", strategy = GenerationType.SEQUENCE)
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

	@Column(name = "salary",precision = 14,scale = 2)
	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Date getMemberdate() {
		return memberdate;
	}

	public void setMemberdate(Date memberdate) {
		this.memberdate = memberdate;
	}

}

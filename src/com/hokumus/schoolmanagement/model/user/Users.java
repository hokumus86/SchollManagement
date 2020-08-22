package com.hokumus.schoolmanagement.model.user;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import javax.persistence.Table;

import com.hokumus.schoolmanagement.model.util.BaseEntity;
//Askin's First Commit Test
@Entity
@Table(name = "schooluser")
public class Users extends BaseEntity {
	private Long id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private String adress;
	private String phone;
	private UserRole role;
	
	
	@SequenceGenerator(name = "seq_user_id",initialValue = 1,allocationSize = 1,sequenceName = "seq_user_id")
	@GeneratedValue(generator ="seq_user_id" ,strategy = GenerationType.SEQUENCE )
	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Enumerated
	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

}

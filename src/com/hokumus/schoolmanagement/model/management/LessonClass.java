package com.hokumus.schoolmanagement.model.management;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.schoolmanagement.model.util.BaseEntity;

@Entity
@Table(name = "room")
public class LessonClass extends BaseEntity {

	private Long id;
	private String name;
	private String code;
	private int capasity;

	@Id
	@SequenceGenerator(name = "seq_room", allocationSize = 1, sequenceName = "seq_room")
	@GeneratedValue(generator = "seq_room", strategy = GenerationType.SEQUENCE)
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCapasity() {
		return capasity;
	}

	public void setCapasity(int capasity) {
		this.capasity = capasity;
	}

}

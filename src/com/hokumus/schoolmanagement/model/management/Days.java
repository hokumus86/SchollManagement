package com.hokumus.schoolmanagement.model.management;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "days")
public class Days {
	private Long id;
	private String name;
	private int gun1;
	private int gun2;
	private int gun3;
	private int gun4;
	private int gun5;
	private int gun6;
	private int gun7;
	private CourseTimes saat;

	@Id
	@SequenceGenerator(name = "seq_lessons", allocationSize = 1, sequenceName = "seq_lessons")
	@GeneratedValue(generator = "seq_lessons", strategy = GenerationType.SEQUENCE)
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

	public int getGun1() {
		return gun1;
	}

	public void setGun1(int gun1) {
		this.gun1 = gun1;
	}

	public int getGun2() {
		return gun2;
	}

	public void setGun2(int gun2) {
		this.gun2 = gun2;
	}

	public int getGun3() {
		return gun3;
	}

	public void setGun3(int gun3) {
		this.gun3 = gun3;
	}

	public int getGun4() {
		return gun4;
	}

	public void setGun4(int gun4) {
		this.gun4 = gun4;
	}

	public int getGun5() {
		return gun5;
	}

	public void setGun5(int gun5) {
		this.gun5 = gun5;
	}

	public int getGun6() {
		return gun6;
	}

	public void setGun6(int gun6) {
		this.gun6 = gun6;
	}

	public int getGun7() {
		return gun7;
	}

	public void setGun7(int gun7) {
		this.gun7 = gun7;
	}

	@Enumerated
	@JoinColumn(name = "clock_id")
	@Column(name = "saat")
	public CourseTimes getSaat() {
		return saat;
	}

	public void setSaat(CourseTimes saat) {
		this.saat = saat;
	}

}

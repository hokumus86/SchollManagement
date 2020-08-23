package com.hokumus.schoolmanagement.model.management;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.hokumus.schoolmanagement.model.util.BaseEntity;

@Entity
@Table(name = "course")
public class Courses extends BaseEntity {
	public Groups Groups = new Groups();
	private Long id;
	private String name;
	private Date starteddate = Groups.getStarteddate();
	private BigDecimal totalprice;
	private String status;

	@Id
	@SequenceGenerator(name = "seq_course", allocationSize = 1, sequenceName = "seq_course")
	@GeneratedValue(generator = "seq_course", strategy = GenerationType.SEQUENCE)
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

	@Column(name = "startdate")
	@Temporal(javax.persistence.TemporalType.DATE)
	public Date getStarteddate() {
		return starteddate;
	}

	public void setStarteddate(Date starteddate) {
		this.starteddate = starteddate;
	}

	public BigDecimal getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

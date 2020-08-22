package com.hokumus.schoolmanagement.model.student;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.hokumus.schoolmanagement.model.management.Groups;
import com.hokumus.schoolmanagement.model.util.BaseEntity;

@Entity
@Table(name = "student_group")
public class StudentGroups extends BaseEntity {

	private Long id;
    private Student student;
    private Groups Groups;
    private BigDecimal totalprice;
    private Date registerdate;

    @Id
    @SequenceGenerator(name = "seq_student_group", allocationSize = 1, sequenceName = "seq_student_group")
    @GeneratedValue(generator = "seq_student_group", strategy = GenerationType.SEQUENCE)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "student_id")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne
    @JoinColumn(name = "groups_id")
	public Groups getGroups() {
		return Groups;
	}

	public void setGroups(Groups groups) {
		Groups = groups;
	}

	@Column(name = "totalprice", scale = 2, precision = 14)
	public BigDecimal getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}

	@Temporal(TemporalType.DATE)
	public Date getRegisterdate() {
		return registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}

    

}

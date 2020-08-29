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

import com.hokumus.schoolmanagement.model.util.BaseEntity;

@Entity
public class StudentPayments extends BaseEntity{
	private Long id;
	private String details;
	private BigDecimal payment;
	private Student student;
	private Date paymentdate;

	@Id
	@SequenceGenerator(name = "seq_student_payment", allocationSize = 1, sequenceName = "seq_student_payment")
	@GeneratedValue(generator = "seq_student_payment", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Column(name = "quantity", scale = 2, precision = 14)
	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	@ManyToOne
	@JoinColumn(name = "student_id")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}

}

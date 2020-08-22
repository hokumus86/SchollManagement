package com.hokumus.schoolmanagement.model.management;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.hokumus.schoolmanagement.model.teacher.Teacher;

@Entity
@Table(name = "groups")
public class Groups {

	private Long id;
	private String name;
	private Courses Courses;
	private Teacher Teacher;
	private int ogrenciSayisi;
	private LessonClass LessonClass;
	private Days Days;
	private Date starteddate;
	private Date finisdate;

	public Long getId() {
		return id;
	}

	@Id
	@SequenceGenerator(name = "seq_group", allocationSize = 1, sequenceName = "seq_group")
	@GeneratedValue(generator = "seq_group", strategy = GenerationType.SEQUENCE)
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	@JoinColumn(name = "course_id")
	public Courses getCourses() {
		return Courses;
	}

	public void setCourses(Courses courses) {
		Courses = courses;
	}

	@ManyToOne
	@JoinColumn(name = "teacher_id")
	public Teacher getTeacher() {
		return Teacher;
	}

	public void setTeacher(Teacher teacher) {
		Teacher = teacher;
	}

	public int getOgrenciSayisi() {
		return ogrenciSayisi;
	}

	public void setOgrenciSayisi(int ogrenciSayisi) {
		this.ogrenciSayisi = ogrenciSayisi;
	}

	@ManyToOne
	@JoinColumn(name = "room_id")
	public LessonClass getLessonClass() {
		return LessonClass;
	}

	public void setLessonClass(LessonClass lessonClass) {
		LessonClass = lessonClass;
	}

	@ManyToOne
	@JoinColumn(name = "days_id")
	public Days getDays() {
		return Days;
	}

	public void setDays(Days days) {
		Days = days;
	}

	public Date getStarteddate() {
		return starteddate;
	}

	public void setStarteddate(Date starteddate) {
		this.starteddate = starteddate;
	}

	public Date getFinisdate() {
		return finisdate;
	}

	public void setFinisdate(Date finisdate) {
		this.finisdate = finisdate;
	}

}

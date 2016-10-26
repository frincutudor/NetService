package com.elektrobit.netservice.view;

import java.util.ArrayList;
import java.util.Date;
import javax.validation.constraints.*;
public class Student {

	private String studentName;
	@Size(min=2 , max=30) @IsValidHobby
	private String studentHobby;
	private long studentMobile;
	private Date studentDOB;
	private ArrayList<String> studentSkills;
	private Adress studentAdress;

	public Adress getStudentAdress() {
		return studentAdress;
	}

	public void setStudentAdress(Adress studentAdress) {
		this.studentAdress = studentAdress;
	}

	public long getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(long studentMobile) {
		this.studentMobile = studentMobile;
	}

	public Date getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}

	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}

	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentHobby() {
		return studentHobby;
	}

	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}

}

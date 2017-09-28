package com.coolspringstuff.jobportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kajal
 */

@Entity
@Table(name = "jobseeker")
public class JobSeeker {
	
	@Id
	@Column(name = "jobseeker_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobSeekerId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "age")
	private int age;
	
	public int getJobSeekerId() {
		return jobSeekerId;
	}
	public void setJobSeekerId(int jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("JobSeeker Id:- " + getJobSeekerId() + " First Name:- " + getFirstName() + " Last Name:- " +
		getLastName() + " Age:- " + getAge());
		return builder.toString();

	}
}

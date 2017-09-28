package com.coolspringstuff.portal.model;

public class JobSeeker {
	private int jobSeekerId;
	private String firstName;
	private String lastName;
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

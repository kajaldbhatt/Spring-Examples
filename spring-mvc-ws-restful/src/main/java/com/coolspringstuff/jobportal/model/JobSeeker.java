package com.coolspringstuff.jobportal.model;

public class JobSeeker {
	private int jobSeekerId;
	private String firstName;
	private String lastName;
	private int age;
	
	public JobSeeker(){
		jobSeekerId=0;
	}
	
	public JobSeeker(int jobSeekerId, String firstName, String lastName, int age){
		this.jobSeekerId = jobSeekerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (jobSeekerId ^ (jobSeekerId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobSeeker other = (JobSeeker) obj;
		if (jobSeekerId != other.jobSeekerId)
			return false;
		return true;
	}

	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("JobSeeker Id:- " + getJobSeekerId() + " First Name:- " + getFirstName() + " Last Name:- " +
		getLastName() + " Age:- " + getAge());
		return builder.toString();

	}
}

package com.coolspringstuff.portal.model;

public class PropertySeeker {
	private int propertySeekerId;
	private String firstName;
	private String lastName;
	private int age;
	
	
	public int getPropertySeekerId() {
		return propertySeekerId;
	}
	public void setPropertySeekerId(int propertySeekerId) {
		this.propertySeekerId = propertySeekerId;
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
		builder.append("PropertySeeker Id:- " + getPropertySeekerId() + " First Name:- " + getFirstName() + " Last Name:- " +
		getLastName() + " Age:- " + getAge());
		return builder.toString();

	}
}

package com.coolspringstuff.jobportal.service;

import java.util.List;

import com.coolspringstuff.jobportal.model.JobSeeker;


public interface JobSeekerService {
	
	JobSeeker findById(long id);
	
	JobSeeker findByName(String name);
	
	void saveJobSeeker(JobSeeker user);
	
	void updateJobSeeker(JobSeeker jobSeeker);
	
	void deleteJobSeekerById(long id);

	List<JobSeeker> findAllJobSeeker(); 
	
	void deleteAllJobSeeker();
	
	public boolean isJobSeekerExist(JobSeeker jobSeeker);
	
}

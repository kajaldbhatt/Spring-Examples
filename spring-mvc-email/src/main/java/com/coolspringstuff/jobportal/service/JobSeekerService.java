package com.coolspringstuff.jobportal.service;

import java.util.List;

import com.coolspringstuff.jobportal.model.JobSeeker;

/**
 * @author Kajal
 */

public interface JobSeekerService {
	public void saveOrUpdate(JobSeeker jobSeeker);
    
    public void delete(int jobSeekerId);
     
    public JobSeeker get(int jobSeekerId);
     
    public List<JobSeeker> list();
    
    public void sendAccountCreationConfirmation(JobSeeker jobSeeker);
}

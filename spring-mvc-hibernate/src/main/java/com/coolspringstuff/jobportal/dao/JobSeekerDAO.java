package com.coolspringstuff.jobportal.dao;

import java.util.List;

import com.coolspringstuff.jobportal.model.JobSeeker;

/**
 * @author Kajal
 */
public interface JobSeekerDAO {
	public void saveOrUpdate(JobSeeker jobSeeker);
    
    public void delete(int jobSeekerId);
     
    public JobSeeker get(int jobSeekerId);
     
    public List<JobSeeker> list();
}

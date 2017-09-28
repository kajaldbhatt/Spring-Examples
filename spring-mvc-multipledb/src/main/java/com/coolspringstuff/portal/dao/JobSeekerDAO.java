package com.coolspringstuff.portal.dao;

import java.util.List;

import com.coolspringstuff.portal.model.JobSeeker;

public interface JobSeekerDAO {
	public void saveOrUpdate(JobSeeker jobSeeker);
    
    public void delete(int jobSeekerId);
     
    public JobSeeker get(int jobSeekerId);
     
    public List<JobSeeker> list();
}

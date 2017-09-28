package com.coolspringstuff.jobportal.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coolspringstuff.jobportal.model.JobSeeker;

/**
 * @author Kajal
 */

@Repository
public class JobSeekerDAOImpl implements JobSeekerDAO{

	@Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public void saveOrUpdate(JobSeeker jobSeeker) {
    		getSession().saveOrUpdate(jobSeeker);   
    }
 
    @Override
    public void delete(int jobSeekerId) {
    	System.out.println("Jobseeker----------"+jobSeekerId);
    	JobSeeker jobSeeker = new JobSeeker();
    	jobSeeker.setJobSeekerId(jobSeekerId);
    	getSession().delete(jobSeeker);
    }
 
    @Override
    public List<JobSeeker> list() {
    	Query<JobSeeker> query =  getSession().createQuery("from JobSeeker");
    	List<JobSeeker> listJobSeeker = new ArrayList<JobSeeker>();
    	listJobSeeker = query.getResultList();
        
    	 return listJobSeeker;
    }
 
    @Override
    public JobSeeker get(int jobSeekerId) {
    	JobSeeker jobSeeker = getSession().get(JobSeeker.class, jobSeekerId);
    	return jobSeeker;
    }
}

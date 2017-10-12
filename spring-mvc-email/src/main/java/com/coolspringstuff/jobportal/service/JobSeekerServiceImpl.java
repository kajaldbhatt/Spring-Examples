package com.coolspringstuff.jobportal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coolspringstuff.jobportal.dao.JobSeekerDAO;
import com.coolspringstuff.jobportal.model.JobSeeker;

/**
 * @author Kajal
 */

@Service("jobSeekerService")
@Transactional
public class JobSeekerServiceImpl implements JobSeekerService{

	@Autowired
    private JobSeekerDAO dao;
	
	@Autowired
    MailService mailService;
	
	 @Override
	public void saveOrUpdate(JobSeeker jobSeeker){
		dao.saveOrUpdate(jobSeeker);
	}
    
	@Override
    public void delete(int jobSeekerId){
    	dao.delete(jobSeekerId);
    }
    
    @Override
    public JobSeeker get(int jobSeekerId){
    	return dao.get(jobSeekerId);
    }
     
    @Override
    public List<JobSeeker> list(){
    	return dao.list();
    	
    }
    
    @Override
    public void sendAccountCreationConfirmation(JobSeeker jobSeeker) {
	    mailService.sendEmail(jobSeeker);
	}

}

package com.coolspringstuff.jobportal.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coolspringstuff.jobportal.model.JobSeeker;

@Service("jobSeekerService")
@Transactional
public class JobSeekerServiceImpl implements JobSeekerService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<JobSeeker> jobSeekers;
	
	static{
		jobSeekers= populateDummyJobSeekers();
	}

	public List<JobSeeker> findAllJobSeeker() {
		return jobSeekers;
	}
	
	public JobSeeker findById(long id) {
		for(JobSeeker jobSeeker : jobSeekers){
			if(jobSeeker.getJobSeekerId() == id){
				return jobSeeker;
			}
		}
		return null;
	}
	
	public JobSeeker findByName(String name) {
		for(JobSeeker jobSeeker : jobSeekers){
			if(jobSeeker.getFirstName().equalsIgnoreCase(name)){
				return jobSeeker;
			}
		}
		return null;
	}
	
	public void saveJobSeeker(JobSeeker jobSeeker) {
		jobSeeker.setJobSeekerId(new Long(counter.incrementAndGet()).intValue());
		jobSeekers.add(jobSeeker);
	}

	public void updateJobSeeker(JobSeeker jobSeeker) {
		int index = jobSeekers.indexOf(jobSeeker);
		jobSeekers.set(index, jobSeeker);
	}

	public void deleteJobSeekerById(long id) {
		
		for (Iterator<JobSeeker> iterator = jobSeekers.iterator(); iterator.hasNext(); ) {
		    JobSeeker jobSeeker = iterator.next();
		    if (jobSeeker.getJobSeekerId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isJobSeekerExist(JobSeeker jobSeeker) {
		return findByName(jobSeeker.getFirstName())!=null;
	}

	private static List<JobSeeker> populateDummyJobSeekers(){
		List<JobSeeker> jobSeekers = new ArrayList<JobSeeker>();
		jobSeekers.add(new JobSeeker(new Long(counter.incrementAndGet()).intValue(),"Kajal","Bhatt",30));
		jobSeekers.add(new JobSeeker(new Long(counter.incrementAndGet()).intValue(),"Dharmik","Mandalia",40));
		jobSeekers.add(new JobSeeker(new Long(counter.incrementAndGet()).intValue(),"Harit","Bhatt", 32));
		jobSeekers.add(new JobSeeker(new Long(counter.incrementAndGet()).intValue(),"Kalgi", "Joshi", 28));
		return jobSeekers;
	}

	public void deleteAllJobSeeker() {
		jobSeekers.clear();
	}

}

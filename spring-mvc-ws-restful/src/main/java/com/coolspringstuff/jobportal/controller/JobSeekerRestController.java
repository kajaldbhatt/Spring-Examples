package com.coolspringstuff.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.coolspringstuff.jobportal.dao.JobSeekerDAO;
import com.coolspringstuff.jobportal.model.*;

@RestController
public class JobSeekerRestController {
	
	@Autowired
    private JobSeekerDAO jobSeekerDAO;
	
	//-------------------Retrieve All Users--------------------------------------------------------
	
	@RequestMapping(value="/jobSeeker/" , method = RequestMethod.GET)
	public ResponseEntity<List<JobSeeker>> listJobSeeker() {
	    List<JobSeeker> listJobSeeker = jobSeekerDAO.list();
	    if(listJobSeeker.isEmpty()){
            return new ResponseEntity<List<JobSeeker>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<JobSeeker>>(listJobSeeker, HttpStatus.OK);
	}
	
	
	//-------------------Retrieve Single User--------------------------------------------------------
	
	@RequestMapping(value = "/jobSeeker/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JobSeeker> getUser(@PathVariable("id") int id) {
		System.out.println("Fetching JobSeeker with id " + id);
		JobSeeker jobSeeker = jobSeekerDAO.get(id);
		if (jobSeeker == null) {
			System.out.println("JobSeeker with id " + id + " not found");
			return new ResponseEntity<JobSeeker>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<JobSeeker>(jobSeeker, HttpStatus.OK);
	}


	//-------------------Create a User--------------------------------------------------------
	
	@RequestMapping(value = "/jobSeeker/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> newJobSeeker(@RequestBody JobSeeker newJobSeeker, UriComponentsBuilder ucBuilder) {
		System.out.println("Creating JobSeeker " + newJobSeeker.getFirstName());
		
		jobSeekerDAO.saveOrUpdate(newJobSeeker);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/jobSeeker/{id}").buildAndExpand(newJobSeeker.getJobSeekerId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	//------------------- Update a User --------------------------------------------------------
	
	@RequestMapping(value = "/jobSeeker/{id}", method = RequestMethod.PUT)
	public ResponseEntity<JobSeeker> updateJobSeeker(@PathVariable("id") int id, @RequestBody JobSeeker jobSeeker) {
		System.out.println("Updating JobSeeker " + jobSeeker.getFirstName());

		JobSeeker currentJobSeeker = jobSeekerDAO.get(id);
		
		if (currentJobSeeker==null) {
			System.out.println("JobSeeker with id " + id + " not found");
			return new ResponseEntity<JobSeeker>(HttpStatus.NOT_FOUND);
		}
		
		currentJobSeeker.setFirstName(jobSeeker.getFirstName());
		currentJobSeeker.setLastName(jobSeeker.getLastName());
		currentJobSeeker.setAge(jobSeeker.getAge());
		
		jobSeekerDAO.saveOrUpdate(currentJobSeeker);
		
		return new ResponseEntity<JobSeeker>(currentJobSeeker, HttpStatus.OK);
	}


	//------------------- Delete a User --------------------------------------------------------
	
	@RequestMapping(value = "/jobSeeker/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<JobSeeker> deleteJobSeeker(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting User with id " + id);
		
		JobSeeker jobSeeker = jobSeekerDAO.get(id);
		if (jobSeeker == null) {
			System.out.println("Unable to delete. JobSeeker with id " + id + " not found");
			return new ResponseEntity<JobSeeker>(HttpStatus.NOT_FOUND);
		}
		
		jobSeekerDAO.delete(id);
	    return new ResponseEntity<JobSeeker>(HttpStatus.NO_CONTENT);
	}
	
}


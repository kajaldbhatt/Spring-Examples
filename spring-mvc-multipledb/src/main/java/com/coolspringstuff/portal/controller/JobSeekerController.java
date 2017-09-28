package com.coolspringstuff.portal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coolspringstuff.portal.dao.JobSeekerDAO;
import com.coolspringstuff.portal.model.JobSeeker;

@Controller
public class JobSeekerController {
	
	@Autowired
    private JobSeekerDAO jobSeekerDAO;
	
	@RequestMapping(value="/listJobSeeker")
	public ModelAndView listJobSeeker(ModelAndView model) throws IOException{
	    List<JobSeeker> listJobSeeker = jobSeekerDAO.list();
	    model.addObject("listJobSeeker", listJobSeeker);
	    model.setViewName("/jobseeker/listJobSeeker");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newJobSeeker", method = RequestMethod.GET)
	public ModelAndView newJobSeeker(ModelAndView model) {
	    JobSeeker newJobSeeker = new JobSeeker();
	    model.addObject("jobSeeker", newJobSeeker);
	    model.setViewName("/jobseeker/jobSeekerForm");
	    return model;
	}
	
	@RequestMapping(value = "/deleteJobSeeker", method = RequestMethod.GET)
	public ModelAndView deleteJobSeeker(HttpServletRequest request) {
	    int jobSeekerId = Integer.parseInt(request.getParameter("id"));
	    jobSeekerDAO.delete(jobSeekerId);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/saveJobSeeker", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute JobSeeker jobSeeker) {
		jobSeekerDAO.saveOrUpdate(jobSeeker);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editJobSeeker", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
	    int jobSeekerId = Integer.parseInt(request.getParameter("id"));
	    JobSeeker jobSeeker = jobSeekerDAO.get(jobSeekerId);
	    ModelAndView model = new ModelAndView("/jobseeker/jobSeekerForm");
	    model.addObject("jobSeeker", jobSeeker);
	 
	    return model;
	}
	
}

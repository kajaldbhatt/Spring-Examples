package com.coolspringstuff.jobportal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.coolspringstuff.jobportal.dao.JobSeekerDAO;
import com.coolspringstuff.jobportal.model.JobSeeker;;

@Controller
public class JobSeekerController {
	@Autowired
    private JobSeekerDAO jobSeekerDAO;
	
	@RequestMapping(value="/jobseeker/{jobSeekerId}", method = RequestMethod.GET)
    public String getPizza(@PathVariable String jobSeekerId, ModelMap model) {
  
        JobSeeker jobSeeker = jobSeekerDAO.get(Integer.parseInt(jobSeekerId));
        model.addAttribute("jobseeker", jobSeeker);
  
        return "jobseeker";
  
    }
	
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

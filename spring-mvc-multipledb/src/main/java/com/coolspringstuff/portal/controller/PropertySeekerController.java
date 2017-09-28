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

import com.coolspringstuff.portal.dao.PropertySeekerDAO;
import com.coolspringstuff.portal.model.PropertySeeker;


@Controller
public class PropertySeekerController {
	@Autowired
    private PropertySeekerDAO propertySeekerDAO;
	
	@RequestMapping(value="/listPropertySeeker")
	public ModelAndView listPropertySeeker(ModelAndView model) throws IOException{
	    List<PropertySeeker> listPropertySeeker = propertySeekerDAO.list();
	    model.addObject("listPropertySeeker", listPropertySeeker);
	    model.setViewName("/propertyseeker/listPropertySeeker");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newPropertySeeker", method = RequestMethod.GET)
	public ModelAndView newPropertySeeker(ModelAndView model) {
	    PropertySeeker newPropertySeeker = new PropertySeeker();
	    model.addObject("propertySeeker", newPropertySeeker);
	    model.setViewName("/propertyseeker/propertySeekerForm");
	    return model;
	}
	
	@RequestMapping(value = "/deletePropertySeeker", method = RequestMethod.GET)
	public ModelAndView deletePropertySeeker(HttpServletRequest request) {
	    int propertySeekerId = Integer.parseInt(request.getParameter("id"));
	    propertySeekerDAO.delete(propertySeekerId);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/savePropertySeeker", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute PropertySeeker propertySeeker) {
		propertySeekerDAO.saveOrUpdate(propertySeeker);
	    return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editPropertySeeker", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
	    int propertySeekerId = Integer.parseInt(request.getParameter("id"));
	    PropertySeeker propertySeeker = propertySeekerDAO.get(propertySeekerId);
	    ModelAndView model = new ModelAndView("/propertyseeker/propertySeekerForm");
	    model.addObject("propertySeeker", propertySeeker);
	 
	    return model;
	}
	
}

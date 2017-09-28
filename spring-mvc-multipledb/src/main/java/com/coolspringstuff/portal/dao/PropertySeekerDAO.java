package com.coolspringstuff.portal.dao;

import java.util.List;

import com.coolspringstuff.portal.model.PropertySeeker;

public interface PropertySeekerDAO {
	public void saveOrUpdate(PropertySeeker propertySeeker);
    
    public void delete(int propertySeekerId);
     
    public PropertySeeker get(int propertySeekerId);
     
    public List<PropertySeeker> list();
}

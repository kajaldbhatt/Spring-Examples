package com.coolspringstuff.portal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.coolspringstuff.portal.model.PropertySeeker;

@Component
public class PropertySeekerDAOImpl implements PropertySeekerDAO{
	
	@Autowired
	@Qualifier("jdbcPropertyPortal")
	private JdbcTemplate jdbcTemplate;
	
	public void saveOrUpdate(PropertySeeker propertySeeker){
		if (propertySeeker.getPropertySeekerId() > 0) {
            // update
            String sql = "UPDATE propertyseeker SET first_name=?, last_name=?, age=? "
                        + " WHERE propertyseeker_id=?";
            jdbcTemplate.update(sql, propertySeeker.getFirstName(), propertySeeker.getLastName(),
            		propertySeeker.getAge(), propertySeeker.getPropertySeekerId());
        } else {
            // insert
            String sql = "INSERT INTO propertyseeker (first_name, last_name, age)"
                        + " VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, propertySeeker.getFirstName(), propertySeeker.getLastName(),
            		propertySeeker.getAge());
        }
	}
    
    public void delete(int propertySeekerId){
    	String sql = "DELETE FROM propertyseeker WHERE propertyseeker_id=?";
	    jdbcTemplate.update(sql, propertySeekerId);
    }
     
    public PropertySeeker get(int propertySeekerId){
    	String sql = "SELECT * FROM propertyseeker WHERE propertyseeker_id=" + propertySeekerId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<PropertySeeker>() {
     
            @Override
            public PropertySeeker extractData(ResultSet rs) throws SQLException,DataAccessException {
                if (rs.next()) {
                	PropertySeeker propertySeeker = new PropertySeeker();
                	propertySeeker.setPropertySeekerId(rs.getInt("jobseeker_id"));
                	propertySeeker.setFirstName(rs.getString("first_name"));
                	propertySeeker.setLastName(rs.getString("last_name"));
                	propertySeeker.setAge(rs.getInt("age"));
    	 
                    return propertySeeker;
                }
     
                return null;
            }
     
        });
    }
     
    public List<PropertySeeker> list(){
    	String sql = "SELECT * FROM propertyseeker";
	    List<PropertySeeker> listPropertySeeker = jdbcTemplate.query(sql, new RowMapper<PropertySeeker>() {
	 
	        @Override
	        public PropertySeeker mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	PropertySeeker propertySeeker = new PropertySeeker();
	 
	        	propertySeeker.setPropertySeekerId(rs.getInt("propertyseeker_id"));
	        	propertySeeker.setFirstName(rs.getString("first_name"));
	        	propertySeeker.setLastName(rs.getString("last_name"));
	        	propertySeeker.setAge(rs.getInt("age"));
	 
	            return propertySeeker;
	        }
	 
	    });
	 
	    return listPropertySeeker;
    }
}

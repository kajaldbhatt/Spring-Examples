package com.coolspringstuff.jobportal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.coolspringstuff.jobportal.model.JobSeeker;

@Component
public class JobSeekerDAOImpl implements JobSeekerDAO{

	private JdbcTemplate jdbcTemplate;

    public JobSeekerDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public void saveOrUpdate(JobSeeker jobSeeker) {
    	if (jobSeeker.getJobSeekerId() > 0) {
            // update
            String sql = "UPDATE jobseeker SET first_name=?, last_name=?, age=? "
                        + " WHERE jobseeker_id=?";
            jdbcTemplate.update(sql, jobSeeker.getFirstName(), jobSeeker.getLastName(),
            		jobSeeker.getAge(), jobSeeker.getJobSeekerId());
        } else {
            // insert
            String sql = "INSERT INTO jobseeker (first_name, last_name, age)"
                        + " VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, jobSeeker.getFirstName(), jobSeeker.getLastName(),
            		jobSeeker.getAge());
        }
    }
 
    @Override
    public void delete(int jobSeekerId) {
    	 String sql = "DELETE FROM jobseeker WHERE jobseeker_id=?";
    	    jdbcTemplate.update(sql, jobSeekerId);
    }
 
    @Override
    public List<JobSeeker> list() {
    	 String sql = "SELECT * FROM jobseeker";
    	    List<JobSeeker> listJobSeeker = jdbcTemplate.query(sql, new RowMapper<JobSeeker>() {
    	 
    	        @Override
    	        public JobSeeker mapRow(ResultSet rs, int rowNum) throws SQLException {
    	        	JobSeeker jobSeeker = new JobSeeker();
    	 
    	        	jobSeeker.setJobSeekerId(rs.getInt("jobseeker_id"));
    	        	jobSeeker.setFirstName(rs.getString("first_name"));
    	        	jobSeeker.setLastName(rs.getString("last_name"));
    	        	jobSeeker.setAge(rs.getInt("age"));
    	 
    	            return jobSeeker;
    	        }
    	 
    	    });
    	 
    	    return listJobSeeker;
    }
 
    @Override
    public JobSeeker get(int jobSeekerId) {
    	String sql = "SELECT * FROM jobseeker WHERE jobseeker_id=" + jobSeekerId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<JobSeeker>() {
     
            @Override
            public JobSeeker extractData(ResultSet rs) throws SQLException,DataAccessException {
                if (rs.next()) {
                    JobSeeker jobSeeker = new JobSeeker();
                    jobSeeker.setJobSeekerId(rs.getInt("jobseeker_id"));
    	        	jobSeeker.setFirstName(rs.getString("first_name"));
    	        	jobSeeker.setLastName(rs.getString("last_name"));
    	        	jobSeeker.setAge(rs.getInt("age"));
    	 
                    return jobSeeker;
                }
     
                return null;
            }
     
        });
    }
}

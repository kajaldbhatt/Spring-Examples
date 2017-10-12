package com.coolspringstuff.jobportal.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.coolspringstuff.jobportal.model.JobSeeker;

/**
 * @author Kajal
 */


@Service("mailService")
public class MailServiceImpl implements MailService{
	 	@Autowired
	    JavaMailSender mailSender;
	 
	    @Override
	    public void sendEmail(Object object) {
	 
	        JobSeeker jobSeeker = (JobSeeker) object;
	 
	        MimeMessagePreparator preparator = getMessagePreparator(jobSeeker);
	 
	        try {
	            mailSender.send(preparator);
	            System.out.println("Message Send...Hurrey");
	        } catch (MailException ex) {
	            System.err.println(ex.getMessage());
	        }
	    }
	 
	    private MimeMessagePreparator getMessagePreparator(final JobSeeker jobSeeker) {
	 
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {
	 
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	                mimeMessage.setFrom("xyz@gmail.com");
	                mimeMessage.setRecipient(Message.RecipientType.TO,
	                        new InternetAddress(jobSeeker.getEmailId()));
	                mimeMessage.setText("Dear " + jobSeeker.getFirstName()
	                        + ", thank you for registering. Happy Job Hunting!");
	                mimeMessage.setSubject("Registration");
	            }
	        };
	        return preparator;
	    }

}

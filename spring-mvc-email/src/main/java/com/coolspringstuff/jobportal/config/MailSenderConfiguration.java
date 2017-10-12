package com.coolspringstuff.jobportal.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author Kajal
 */

@Configuration
@ComponentScan(basePackages="com.coolspringstuff.jobportal")
public class MailSenderConfiguration {
	
	@Autowired
    private Environment env;
	
	@Bean
    public JavaMailSender getMailSender(){
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
         
        //Using gmail
        mailSender.setHost(env.getRequiredProperty("mail.smtp.server"));
        mailSender.setPort(Integer.parseInt(env.getRequiredProperty("mail.smtp.port")));
        mailSender.setUsername(env.getRequiredProperty("mail.smtp.account.id"));
        mailSender.setPassword(env.getRequiredProperty("mail.smtp.account.password"));
         
        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", env.getRequiredProperty("mail.smtp.starttls.enable"));
        javaMailProperties.put("mail.smtp.auth", env.getRequiredProperty("mail.smtp.auth"));
        javaMailProperties.put("mail.transport.protocol",env.getRequiredProperty("mail.transport.protocol"));
        javaMailProperties.put("mail.debug", env.getRequiredProperty("mail.debug"));
         
        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }
}

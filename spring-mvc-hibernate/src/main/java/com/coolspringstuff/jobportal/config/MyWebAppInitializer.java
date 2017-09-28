package com.coolspringstuff.jobportal.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Kajal
 */
public class MyWebAppInitializer extends 
   AbstractAnnotationConfigDispatcherServletInitializer{

   @Override
   protected Class<?>[] getRootConfigClasses() {
      return new Class[]{RootConfig.class};
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[]{MVCConfiguration.class};
   }

   @Override
   protected String[] getServletMappings() {
      return new String[]{"/"};
   }
}

package com.my.sasa;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {HomeConfig.class}; // We dont need any special servlet config yet.
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
    	return new Class[] {HomeConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
    
}
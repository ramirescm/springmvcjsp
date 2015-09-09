package com.springmvcjsp.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

public class MainWebAppInitializer implements WebApplicationInitializer { 
    public void onStartup(ServletContext servletContext) throws ServletException { 
        registerCharacterEncodingFilter(servletContext); 
    } 

    private void registerCharacterEncodingFilter(final ServletContext servletContext) { 
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter(); 
        characterEncodingFilter.setEncoding("UTF-8"); 
        characterEncodingFilter.setForceEncoding(true); 
        FilterRegistration.Dynamic filter = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter); 
        filter.addMappingForUrlPatterns(null, true, "/*"); 
    } 
}

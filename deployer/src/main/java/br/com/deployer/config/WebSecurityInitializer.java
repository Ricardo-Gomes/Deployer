package br.com.deployer.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
	
	@Override
	protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
		super.afterSpringSecurityFilterChain(servletContext);
		
		FilterRegistration filterRegistration = servletContext.getFilterRegistration( AbstractSecurityWebApplicationInitializer.DEFAULT_FILTER_NAME );
		filterRegistration.addMappingForUrlPatterns( EnumSet.of( DispatcherType.FORWARD , DispatcherType.REQUEST , DispatcherType.ERROR ) , true ,  "/*");
		
//		servletContext.setInitParameter("javax.faces.FACELETS_LIBRARIES", "/WEB-INF/springsecurity.taglib.xml;");
	}
	
}
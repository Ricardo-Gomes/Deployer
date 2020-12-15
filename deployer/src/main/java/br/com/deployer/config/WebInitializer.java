package br.com.deployer.config;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		registerContextLoaderListener(servletContext);
		
		servletContext.addServlet("Faces Servlet", FacesServlet.class );
		ServletRegistration servletRegistration = servletContext.getServletRegistration("Faces Servlet");
		servletRegistration.addMapping("*.xhtml");
		
		servletContext.setInitParameter("primefaces.THEME" , "bootstrap");
		servletContext.setInitParameter("primefaces.FONT_AWESOME" , "true");
		servletContext.setInitParameter("javax.faces.DATETIMECONVERTER_DEFAULT_TIMEZONE_IS_SYSTEM_TIMEZONE" , "true" );
		servletContext.setInitParameter("javax.faces.INTERPRET_EMPTY_STRING_SUBMITTED_VALUES_AS_NULL" , "false" );
		servletContext.setInitParameter("com.sun.faces.allowTextChildren" , "true" );
		servletContext.setInitParameter("com.sun.faces.enableMissingResourceLibraryDetection" , "native" );
		servletContext.setInitParameter("primefaces.UPLOADER" , "native" );		

	}
	
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{ SpringConfiguration.class ,SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{  };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}

package com.fnds.config;

public class MyWebAppInitializer {// implements WebApplicationInitializer {
// we use AbstractAnnotationConfigDispatcherServletInitializer or WebApplicationInitializer
// better to user former one	
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
//		appContext.register(Configuration.class);
//		appContext.setServletContext(servletContext);
//		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping("/");
//	}

}

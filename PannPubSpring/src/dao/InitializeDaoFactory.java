package dao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitializeDaoFactory implements ServletContextListener {
	
	private DAOFactory daoFactory;

	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		try {
			this.daoFactory = DAOFactory.getInstance();
			servletContext.setAttribute("daoFactory", this.daoFactory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent event) {
	}
	
}

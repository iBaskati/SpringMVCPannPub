package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DAOFactory {

	private String url;
	private String userName;
	private String password;
	private static final String PROPERTIES_FILE = "dao.properties";
	private static final String PROPERTY_URL = "url";
	private static final String PROPERTY_DRIVER = "driver";
	private static final String PROPERTY_USER_NAME = "userName";
	private static final String PROPERTY_PASSWORD = "password";
	
	private DAOFactory(String url, String userName, String password) {
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	public static DAOFactory getInstance() throws Exception  {
		Properties properties = new Properties();
		String url;
		String driver;
		String userName;
		String password;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream propritiesFile = classLoader.getResourceAsStream( PROPERTIES_FILE );
		if ( propritiesFile == null ) {
			throw new Exception ( "Properties file " + PROPERTIES_FILE + " can't be found." );
		}
		try {
			properties.load( propritiesFile );
			url = properties.getProperty( PROPERTY_URL );
			driver = properties.getProperty( PROPERTY_DRIVER );
			userName = properties.getProperty(PROPERTY_USER_NAME );
			password = properties.getProperty(PROPERTY_PASSWORD );
		} catch ( IOException e ) {
			throw new Exception( "Impossible to charge " + PROPERTIES_FILE, e );
		}
		try{
			Class.forName(driver);
		}
		catch(ClassNotFoundException e){
			throw new Exception( "Drive can't be found.", e );
		}
		DAOFactory instance = new DAOFactory(url, userName, password);
		return instance;
	}
	
	
	
	Connection getConnection() throws SQLException {
		return DriverManager.getConnection( url, userName, password);
	}
	
	
	
	public	ClientDao getUtilisateurDao() {
		return new ClientDaoImpl(this);
	}

}

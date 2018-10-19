package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import models.Client;
import static dao.DAOUsefulStuff.*;

public class ClientDaoImpl implements ClientDao {
	
	private DAOFactory daoFactory;
	@Autowired
	private static final String SQL_SELECT_BY_EMAIL = "SELECT id, email, nom, mot_de_passe, date_inscription FROM Utilisateur WHEREemail = ?";

	
	@Override
	public void create(Client client) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client find(String email) throws Exception {
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Client client = null;
		try {
			connexion = daoFactory.getConnection();
			preparedStatement = initialisationPreparedStatement(connexion, SQL_SELECT_BY_EMAIL, false, email);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				client = map(resultSet);
			}
		} catch (SQLException e) {
			throw new Exception(e);
		} finally {
			close(resultSet, preparedStatement, connexion);
		}
		return client;
	}
	
	public ClientDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	

}

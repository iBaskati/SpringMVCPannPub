package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Client;

public class DAOUsefulStuff {
	
	
	public static PreparedStatement initialisationPreparedStatement(Connection connexion, String sql,boolean returnGeneratedKeys, Object... objets) throws SQLException {
		PreparedStatement preparedStatement = connexion.prepareStatement(sql,returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		for (int i = 0; i < objets.length; i++) {
			preparedStatement.setObject(i + 1, objets[i]);
		}
		return preparedStatement;
	}
	
	
	
	public static Client map(ResultSet resultSet) throws SQLException {
		Client client = new Client();
		client.setId(resultSet.getLong("id"));
		client.setEmail(resultSet.getString("email"));
		client.setPassword(resultSet.getString("mot_de_passe"));
		client.setName(resultSet.getString("nom"));
		return client;
	}
	
	public static void close( ResultSet resultSet ) {
		if ( resultSet != null ) {
			try {
				resultSet.close();
			} catch ( SQLException e ) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void close( Statement statement ) {
		if ( statement != null ) {
			try {
				statement.close();
			} catch ( SQLException e ) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void close( Connection connexion ) {
		if ( connexion != null ) {
			try {
				connexion.close();
			} catch ( SQLException e ) {
				System.out.println(e.getMessage());
			}
		}
	}

	
	public static void close(ResultSet resultSet, Statement statement, Connection connexion) {
		close(resultSet);
		close(statement);
		close(connexion);
	}
	
	
}

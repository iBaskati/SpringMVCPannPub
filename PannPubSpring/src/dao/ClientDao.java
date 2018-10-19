package dao;

import models.Client;

public interface ClientDao {
	void create( Client client ) throws Exception;
	Client find( String email ) throws Exception;
}

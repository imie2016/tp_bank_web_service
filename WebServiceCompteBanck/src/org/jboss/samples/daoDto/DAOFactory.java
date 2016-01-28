package org.jboss.samples.daoDto;

import java.sql.Connection;

public class DAOFactory {
	protected static final Connection conn = DAOConnection.getInstance();
	
	public static DAO getCompteDAO(){
		return new CompteDao(conn);
	}
}

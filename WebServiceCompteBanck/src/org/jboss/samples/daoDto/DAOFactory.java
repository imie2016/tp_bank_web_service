package org.jboss.samples.daoDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {

	private String url = "jdbc:postgresql://localhost:5432/banck";
	private String username = "postgres";
	private String password = "P@ssword";
	private String driver = "org.postgresql.Driver";
	private static Connection connect;
	private static DAOFactory instance;

    public DAOFactory( ) {
        try {
			Class.forName(driver);
			System.out.println("Driver chargé");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
        try {
        	connect = DriverManager.getConnection(url, username, password);
			System.out.println("Connecté a la base");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public static DAOFactory getInstance() {
		if (DAOFactory.instance == null) {
			System.out.println("ouverture d'une nouvelle connection");
			synchronized (DAOFactory.class) {
				DAOFactory.instance = new DAOFactory();
			}
		}
		System.out.println("une connection est deja ouvverte");
		return instance;
	}

	public Connection getConnection() {
		Connection c = connect;
		return c;

	}

	public static void fermetureConnextion() {
		try {
			connect.close();
			System.out.println("Déconnecté du serveur");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

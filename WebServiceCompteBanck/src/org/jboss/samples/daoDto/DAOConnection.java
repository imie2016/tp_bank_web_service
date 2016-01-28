package org.jboss.samples.daoDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConnection {

	private static String url = "jdbc:postgresql://localhost:5432/banck";
	private static String username = "postgres";
	private static String password = "P@ssword";
	private static String driver = "org.postgresql.Driver";
	private static Connection connect;
	private static DAOConnection instance;

    public DAOConnection( ) {
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

    public static Connection getInstance() {
		if (connect == null) {
			System.out.println("ouverture d'une nouvelle connection");
			try {
				connect = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return connect;
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

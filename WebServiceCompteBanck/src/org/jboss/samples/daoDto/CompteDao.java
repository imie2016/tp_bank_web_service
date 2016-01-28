package org.jboss.samples.daoDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class CompteDao extends DAO<CompteDTO>{
	



	Connection connexion = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<CompteDTO> compteResult = new ArrayList<>();
	
	public CompteDao(Connection conn) {
		super(conn);
		connexion = conn;
	}
    
	@Override
	public List<CompteDTO> findAll() {
		
	    String SQL_REQ = "SELECT * FROM compte";

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, false);
	        resultSet = preparedStatement.executeQuery();
	        //System.out.println("hop");
	        /* ParcouresultSet de la ligne de données de l'éventuel ResulSet retourné */
	        while (resultSet.next()) {
	        	CompteDTO ligne2 = new CompteDTO(resultSet.getInt("id"), resultSet.getInt("solde"), resultSet.getInt("proprietaires_id"));
	        	compteResult.add(ligne2);
				//System.out.println(resultSet.getInt("id") + " " + resultSet.getInt("solde") + " " +  resultSet.getInt("proprietaires_id"));
			}
	    } catch ( SQLException e ) {
	    	e.printStackTrace();
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		return compteResult;
	}

	@Override
	public List<CompteDTO> findById(Integer id) {
	    String SQL_REQ = "SELECT * FROM compte WHERE id = ?";
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, false, id);
	        resultSet = preparedStatement.executeQuery();
	        //System.out.println("hop");
	        /* ParcouresultSet de la ligne de données de l'éventuel ResulSet retourné */
	        while (resultSet.next()) {
	        	CompteDTO ligne2 = new CompteDTO(resultSet.getInt("id"), resultSet.getInt("solde"), resultSet.getInt("proprietaires_id"));
	        	compteResult.add(ligne2);
	        	System.out.println(resultSet.getInt("id") + " " + resultSet.getInt("solde") + " " +  resultSet.getInt("proprietaires_id"));
				
				}
	    } catch ( SQLException e ) {
	    	e.printStackTrace();
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		return compteResult;
	}

	@Override
	public boolean create(CompteDTO compte) {
		String SQL_REQ = "insert into compte(solde, proprietaires_id) values (?, ?)";
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, false, compte.getSolde(), compte.getProprietaires_id());
	        resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	        	CompteDTO ligne2 = new CompteDTO(resultSet.getInt("id"), resultSet.getInt("solde"), resultSet.getInt("proprietaires_id"));
	        	compteResult.add(ligne2);
	        	System.out.println(resultSet.getInt("id") + " " + resultSet.getInt("solde") + " " +  resultSet.getInt("proprietaires_id"));
				
				}
	    } catch ( SQLException e ) {
	    	e.printStackTrace();
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		return false;
	}

	@Override
	public boolean update(CompteDTO compte) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(CompteDTO compte) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * Initialise la requête préparée basée sur la connexion passée en argument,
	 * avec la requête SQL et les objets donnés.
	 */
	private static PreparedStatement initialisationRequetePreparee( Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}
	/* Fermeture silencieuse du resultset */

	public static void fermetureSilencieuse( ResultSet resultSet ) {

	    if ( resultSet != null ) {

	        try {
	            resultSet.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Échec de la fermeture du ResultSet : " + e.getMessage() );
	        }
	    }
	}
	/* Fermeture silencieuse du statement */

	public static void fermetureSilencieuse( Statement statement ) {

	    if ( statement != null ) {

	        try {

	            statement.close();

	        } catch ( SQLException e ) {

	            System.out.println( "Échec de la fermeture du Statement : " + e.getMessage() );

	        }

	    }

	}


	/* Fermeture silencieuse de la connexion */

	public static void fermetureSilencieuse( Connection connexion ) {

	    if ( connexion != null ) {

	        try {

	            connexion.close();

	        } catch ( SQLException e ) {

	            System.out.println( "Échec de la fermeture de la connexion : " + e.getMessage() );

	        }

	    }

	}


	/* Fermetures silencieuses du statement et de la connexion */

	public static void fermeturesSilencieuses( Statement statement, Connection connexion ) {

	    fermetureSilencieuse( statement );

	    fermetureSilencieuse( connexion );

	}


	/* Fermetures silencieuses du resultset, du statement et de la connexion */

	public static void fermeturesSilencieuses( ResultSet resultSet, Statement statement, Connection connexion ) {

	    fermetureSilencieuse( resultSet );

	    fermetureSilencieuse( statement );

	    fermetureSilencieuse( connexion );

	}


}

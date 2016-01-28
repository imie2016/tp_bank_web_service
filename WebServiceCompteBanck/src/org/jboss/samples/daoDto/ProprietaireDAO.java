package org.jboss.samples.daoDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ProprietaireDAO implements ProprietaireImpl{
	Connection connexion = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<ProprietaireDTO> proprietaireResult = new ArrayList<>();
	
	@Override
	public List<ProprietaireDTO> findAll() {
		
	    String SQL_REQ = "SELECT * FROM proprietaire";

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	DAOFactory daof = DAOFactory.getInstance();
	    	connexion = daof.getConnection();
	    	connexion.setAutoCommit(false);
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, false);
	        resultSet = preparedStatement.executeQuery();
	        
	        /* ParcouresultSet de la ligne de données de l'éventuel ResulSet retourné */
	        while (resultSet.next()) {
	        	ProprietaireDTO ligne2 = new ProprietaireDTO(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("prenom"));
	        	proprietaireResult.add(ligne2);
				System.out.println(resultSet.getInt("id") + " " + resultSet.getString("nom") + " " +  resultSet.getString("prenom"));
			}
	    } catch ( SQLException e ) {
	    	e.printStackTrace();
	    } finally {
	    	
		    	try {
					connexion.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		    	fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		return proprietaireResult;
	}

	
	@Override
	public ProprietaireDTO findById(Integer id) {
	    String SQL_REQ = "SELECT * FROM proprietaire WHERE id = ?";
	    ProprietaireDTO ligne2 = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	DAOFactory daof = DAOFactory.getInstance();
	    	connexion = daof.getConnection();
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, false, id);
	        resultSet = preparedStatement.executeQuery();
	        //System.out.println("hop");
	        /* ParcouresultSet de la ligne de données de l'éventuel ResulSet retourné */
	        while (resultSet.next()) {
	        	ligne2 = new ProprietaireDTO(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("prenom"));
	        	System.out.println(resultSet.getInt("id") + " " + resultSet.getString("nom") + " " +  resultSet.getString("prenom"));
				}
	    } catch ( SQLException e ) {
	    	e.printStackTrace();
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		return ligne2;
	}

	@Override
	public boolean create(ProprietaireDTO proprietaire) {
		String SQL_REQ = "insert into proprietaire(nom, prenom) values (?, ?)";
		Integer resultSetInt = null;
	    try {
	    	DAOFactory daof = DAOFactory.getInstance();
	    	connexion = daof.getConnection();
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, true, proprietaire.getNom(), proprietaire.getPrenom());
	        resultSetInt = preparedStatement.executeUpdate();
	        
	       // resultSet.next(); //lecture de tout le contenu
	        if (resultSetInt == 1) {
	        	System.out.println("Le proprietaire est créé avec un nom de "+proprietaire.getNom());
	        	return true;
			} else{
				System.out.println("Proprietaire non créé");
				return false;
			}

	    } catch ( SQLException e ) {
	    	e.printStackTrace();
	    	return false;
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		
	}

	@Override
	public boolean update(ProprietaireDTO proprietaire) {
		String SQL_REQ = "UPDATE proprietaire SET nom = ?, prenom = ? WHERE id = ?";
		Integer resultSetInt = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	DAOFactory daof = DAOFactory.getInstance();
	    	connexion = daof.getConnection();
	    	
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, true, proprietaire.getNom(), proprietaire.getPrenom(), proprietaire.getId());
	        resultSetInt = preparedStatement.executeUpdate();
	        
	        if (resultSetInt == 1) {
	        	System.out.println("Proprietaire mis à jour, id="+proprietaire.getId()+" nom="+proprietaire.getNom()+" proprio="+proprietaire.getPrenom());
	        	return true;
	        } else{
				System.out.println("Proprietaire non mis à jour");
				return false;
			}

	    } catch ( SQLException e ) {
	    	e.printStackTrace();
	    	return false;
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	}

	
	
	@Override
	public boolean delete(ProprietaireDTO proprietaire) {
		String SQL_REQ = "DELETE FROM proprietaire WHERE id=?";
		Integer resultSetInt = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	DAOFactory daof = DAOFactory.getInstance();
	    	connexion = daof.getConnection();
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, true, proprietaire.getId());
	        resultSetInt = preparedStatement.executeUpdate();

	        if (resultSetInt == 1) {
	        	System.out.println("Proprietaire supprimé =  "+proprietaire.getId());
	        	return true;
	        } else{
				System.out.println("Proprietaire non supprimé");
				return false;
			}

	    } catch ( SQLException e ) {
	    	e.printStackTrace();
	    	return false;
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
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


//	/* Fermeture silencieuse de la connexion */
//	public static void fermetureSilencieuse( Connection connexion ) {
//	    if ( connexion != null ) {
//	        try {
//	            connexion.close();
//	        } catch ( SQLException e ) {
//	            System.out.println( "Échec de la fermeture de la connexion : " + e.getMessage() );
//	        }
//	    }
//	}


	/* Fermetures silencieuses du statement et de la connexion */
	public static void fermeturesSilencieuses( Statement statement, Connection connexion ) {
	    fermetureSilencieuse( statement );
//	    fermetureSilencieuse( connexion );
	}


	/* Fermetures silencieuses du resultset, du statement et de la connexion */
	public static void fermeturesSilencieuses( ResultSet resultSet, Statement statement, Connection connexion ) {
	    fermetureSilencieuse( resultSet );
	    fermetureSilencieuse( statement );
//	    fermetureSilencieuse( connexion );
	}


}

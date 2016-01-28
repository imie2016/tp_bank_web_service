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
	    	connexion.setAutoCommit(false);

	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, false);
	        resultSet = preparedStatement.executeQuery();
	        
	        /* ParcouresultSet de la ligne de données de l'éventuel ResulSet retourné */
	        while (resultSet.next()) {
	        	CompteDTO ligne2 = new CompteDTO(resultSet.getInt("id"), resultSet.getInt("solde"), resultSet.getInt("proprietaires_id"));
	        	compteResult.add(ligne2);
				System.out.println(resultSet.getInt("id") + " " + resultSet.getInt("solde") + " " +  resultSet.getInt("proprietaires_id"));
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
		return compteResult;
	}

	@Override
	public List<CompteDTO> findByProprio(ProprietaireDTO proprio) {
		
	    String SQL_REQ = "SELECT * FROM compte WHERE proprietaires_id = ?";

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	connexion.setAutoCommit(false);
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, false);
	        resultSet = preparedStatement.executeQuery();
	        
	        /* ParcouresultSet de la ligne de données de l'éventuel ResulSet retourné */
	        while (resultSet.next()) {
	        	CompteDTO ligne2 = new CompteDTO(resultSet.getInt("id"), resultSet.getInt("solde"), resultSet.getInt("proprietaires_id"));
	        	compteResult.add(ligne2);
				System.out.println(resultSet.getInt("id") + " " + resultSet.getInt("solde") + " " +  resultSet.getInt("proprietaires_id"));
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
		return compteResult;
	}
	
	@Override
	public CompteDTO findById(Integer id) {
	    String SQL_REQ = "SELECT * FROM compte WHERE id = ?";
	    CompteDTO ligne2 = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, false, id);
	        resultSet = preparedStatement.executeQuery();
	        //System.out.println("hop");
	        /* ParcouresultSet de la ligne de données de l'éventuel ResulSet retourné */
	        while (resultSet.next()) {
	        	ligne2 = new CompteDTO(resultSet.getInt("id"), resultSet.getInt("solde"), resultSet.getInt("proprietaires_id"));
	        	System.out.println(resultSet.getInt("id") + " " + resultSet.getInt("solde") + " " +  resultSet.getInt("proprietaires_id"));
				}
	    } catch ( SQLException e ) {
	    	e.printStackTrace();
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
		return ligne2;
	}

	@Override
	public boolean create(CompteDTO compte) {
		String SQL_REQ = "insert into compte(solde, proprietaires_id) values (?, ?)";
		Integer resultSetInt = null;
	    try {

	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, true, compte.getSolde(), compte.getProprietaires_id());
	        resultSetInt = preparedStatement.executeUpdate();
	        
	       // resultSet.next(); //lecture de tout le contenu
	        if (resultSetInt == 1) {
	        	System.out.println("Le compte est créé avec un solde de "+compte.getSolde());
	        	return true;
			} else{
				System.out.println("Compte non créé");
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
	public boolean update(CompteDTO compte) {
		String SQL_REQ = "UPDATE compte SET solde = ?, proprietaires_id = ? WHERE id = ?";
		Integer resultSetInt = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, true, compte.getSolde(), compte.getProprietaires_id(), compte.getId());
	        resultSetInt = preparedStatement.executeUpdate();
	        
	        if (resultSetInt == 1) {
	        	System.out.println("Compte mis à jour, id="+compte.getId()+" solde="+compte.getSolde()+" proprio="+compte.getProprietaires_id());
	        	return true;
	        } else{
				System.out.println("Compte non mis à jour");
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
	public boolean transactionDepot(CompteDTO compte, Integer montant) {
		String SQL_REQ = "UPDATE compte SET solde = ? WHERE id = ?";
		Integer resultSetInt = null;
		montant += compte.getSolde();
	    try {
	        /* Récupération d'une connexion depuis la Factory */

	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, true, montant, compte.getProprietaires_id(), compte.getId());
	        resultSetInt = preparedStatement.executeUpdate();
	        
	        if (resultSetInt == 1) {
	        	System.out.println("Compte mis à jour, id="+compte.getId()+" solde="+compte.getSolde()+"=>"+montant+" proprio="+compte.getProprietaires_id());
	        	return true;
	        } else{
				System.out.println("Compte non mis à jour");
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
	public boolean transactionRetrait(CompteDTO compte, Integer montant) {
		String SQL_REQ = "UPDATE compte SET solde = ? WHERE id = ?";
		Integer resultSetInt = null;
		montant = compte.getSolde()-montant;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	    	
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, true, montant, compte.getProprietaires_id(), compte.getId());
	        resultSetInt = preparedStatement.executeUpdate();
	        
	        if (resultSetInt == 1) {
	        	System.out.println("Compte mis à jour, id="+compte.getId()+" solde="+compte.getSolde()+"=>"+montant+" proprio="+compte.getProprietaires_id());
	        	return true;
	        } else{
				System.out.println("Compte non mis à jour");
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
	public boolean delete(CompteDTO compte) {
		String SQL_REQ = "DELETE FROM compte WHERE id=?";
		Integer resultSetInt = null;
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        preparedStatement = initialisationRequetePreparee(connexion, SQL_REQ, true, compte.getId());
	        resultSetInt = preparedStatement.executeUpdate();

	        if (resultSetInt == 1) {
	        	System.out.println("Compte supprimé =  "+compte.getId());
	        	return true;
	        } else{
				System.out.println("Compte non supprimé");
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

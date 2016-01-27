package org.jboss.samples.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.jboss.samples.daoDto.Compte;
import org.jboss.samples.daoDto.CompteDao;
import org.jboss.samples.daoDto.DAOFactory;

@WebService()
public class Banck {

	@WebMethod()
	public void testConnexion() {
	    System.out.println("demarrage test connexion");
		DAOFactory.getInstance();
	    //hopla
	}
	
	@WebMethod()
	public String creerCompte(Integer identifiantProprietaire) {
	    
		return result;
	}
	@WebMethod()
	public Integer SoldeCompte(Integer identifiantProprietaire) {
	    
	    return null;
	}
	@WebMethod()
	public Integer deposerArgent(Integer identifiantProprietaire) {
	    
		//return le solde
	    return null;
	}
	@WebMethod()
	public Integer retirerArgent(Integer identifiantProprietaire) {
	    
		//return le solde
	    return null;
	}
}

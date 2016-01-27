package org.jboss.samples.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.jboss.samples.daoDto.DAOFactory;
import org.jboss.samples.services.CompteCTRL;

@WebService()
public class Banck {
	private CompteCTRL compte = new CompteCTRL();;
	private String message = "";
	
	//test appel
	@WebMethod()
	public void testConnexion() {
	    System.out.println("demarrage du test de connexion :");
		DAOFactory.getInstance();
		
	}
	
	@WebMethod()
	public String creerCompte(Proprietaire proprio) {
		return compte.ajouterCompte(proprio);
	}
	@WebMethod()
	public String SoldeCompte(Integer identifiantProprietaire) {
	    
	    return null;
	}
	@WebMethod()
	public String deposerArgent(Integer identifiantProprietaire) {
	    
		//return le solde
	    return null;
	}
	@WebMethod()
	public String retirerArgent(Integer identifiantProprietaire) {
	    
		//return le solde
	    return null;
	}
}

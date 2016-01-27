package org.jboss.samples.webservices;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService()
public class Banck {

	
	//test appel factory
	@WebMethod()
	public void creerCompte(Integer identifiantProprietaire) {
	    
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

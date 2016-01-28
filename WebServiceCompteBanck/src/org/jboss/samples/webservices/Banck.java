package org.jboss.samples.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.jboss.samples.daoDto.CompteDTO;
import org.jboss.samples.daoDto.CompteDao;
import org.jboss.samples.daoDto.DAO;
import org.jboss.samples.daoDto.DAOConnection;
import org.jboss.samples.daoDto.ProprietaireDTO;
import org.jboss.samples.services.CompteCTRL;

@WebService()
public class Banck {
	private CompteCTRL compte = new CompteCTRL();;
	private String message = "";
	
	//test appel
	@WebMethod()
	public void testConnexion() {
	    System.out.println("demarrage du test de connexion :");
		DAOConnection.getInstance();
		
	}
	
//	@WebMethod()
//	public String creerCompte(Proprietaire proprio) {
//		return compte.ajouterCompte(proprio);
//	}
	@WebMethod()
	public List<String> SoldesComptes(ProprietaireDTO proprio) {
		List<CompteDTO> listeDesComptes= new ArrayList<CompteDTO>();
		List<String> listeDesComptesString = new ArrayList<String>();
		
		DAO<CompteDTO> test = new CompteDao(DAOConnection.getInstance());
		listeDesComptes = test.findByProprio(proprio);
		
		for (CompteDTO compteDTO : listeDesComptes) {
			listeDesComptesString.add("id="+compteDTO.getId()+" solde="+compteDTO.getSolde());
		}
	    return listeDesComptesString;
	}
	@WebMethod()
	public boolean deposerArgent(CompteDTO compte, Integer montant) {
		DAO<CompteDTO> test = new CompteDao(DAOConnection.getInstance());
	    return test.transactionDepot(compte, montant);
	}
	@WebMethod()
	public boolean retirerArgent(CompteDTO compte, Integer montant) {
		DAO<CompteDTO> test = new CompteDao(DAOConnection.getInstance());
	    return test.transactionRetrait(compte, montant);
	}
}

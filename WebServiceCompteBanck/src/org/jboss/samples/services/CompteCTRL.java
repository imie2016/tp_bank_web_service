package org.jboss.samples.services;

import java.util.List;

import org.jboss.samples.daoDto.Compte;
import org.jboss.samples.daoDto.CompteDao;
import org.jboss.samples.daoDto.DAOFactory;
import org.jboss.samples.daoDto.Proprietaire;

public class CompteCTRL implements CompteS{

	public CompteCTRL() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CompteDao> listerCompte(ProprietaireS proprio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ajouterCompte(Proprietaire proprio, Compte newCompte) {
			try {
				Compte compte = new CompteDao();
				compte.setNom(newCompte.get)
				//compte.ajouterCompte(proprio, newCompte);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		return false;
	}

	@Override
	public boolean modifierCompte(CompteS updateCompte) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimerCompte(CompteS deleteCompte) {
		// TODO Auto-generated method stub
		return false;
	}


	
}

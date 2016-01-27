package org.jboss.samples.daoDto;

import java.util.List;

public class CompteDao implements Compte{

	@Override
	public List<CompteDao> listerCompte(Proprietaire proprio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean ajouterCompte(Proprietaire proprio, Compte newCompte) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifierCompte(Compte updateCompte) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimerCompte(Compte deleteCompte) {
		// TODO Auto-generated method stub
		return false;
	}

}

package org.jboss.samples.services;

import java.util.List;

import org.jboss.samples.daoDto.ProprietaireDAO;

public interface Proprietaire {
	
	public List<ProprietaireDAO> listerProprietaire();
	
	public ProprietaireDAO afficherProprietaire();
	
	public boolean ajouterProprietaire();
	
	public boolean modifierProprietaire();
	
	public boolean supprimerProprietaire();

}

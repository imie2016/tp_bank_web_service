package org.jboss.samples.daoDto;

import java.util.List;

public interface Proprietaire {
	
	public List<ProprietaireDAO> listerProprietaire();
	
	public ProprietaireDAO afficherProprietaire();
	
	public boolean ajouterProprietaire();
	
	public boolean modifierProprietaire();
	
	public boolean supprimerProprietaire();

}

package org.jboss.samples.daoDto;

import java.util.List;

public interface Proprietaire {
	
	public List<ProprietaireDAO> listerProprietaire();
	
	public boolean ajouterPropripetaire();
	
	public boolean modifierProprietaire();
	
	public boolean supprimerProprietaire();

}

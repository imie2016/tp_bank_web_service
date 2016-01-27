package org.jboss.samples.services;

import java.util.List;

import org.jboss.samples.daoDto.*;

public interface ProprietaireS {
	
	public List<ProprietaireDAO> listerProprietaire();
	public ProprietaireDAO afficherProprietaire(Integer id);
	public boolean ajouterProprietaire(ProprietaireS newProprio);
	public boolean modifierProprietaire(ProprietaireS updateProprio);
	public boolean supprimerProprietaire(ProprietaireS deleteProprio);

}

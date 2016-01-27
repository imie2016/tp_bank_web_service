package org.jboss.samples.daoDto;

import java.util.List;

import org.jboss.samples.daoDto.*;

public interface Proprietaire {
	
	public List<ProprietaireDAO> listerProprietaire();
	public ProprietaireDAO afficherProprietaire(Integer id);
	public boolean ajouterProprietaire(Proprietaire newProprio);
	public boolean modifierProprietaire(Proprietaire updateProprio);
	public boolean supprimerProprietaire(Proprietaire deleteProprio);

}

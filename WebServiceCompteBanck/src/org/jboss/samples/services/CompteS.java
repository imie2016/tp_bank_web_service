package org.jboss.samples.services;

import java.util.List;
import org.jboss.samples.daoDto.*;

public interface CompteS {
	List<CompteDao> listerCompte(ProprietaireS proprio);
//	boolean ajouterCompte(Proprietaire proprio, Compte newCompte);
//	boolean modifierCompte(Compte updateCompte);
//	boolean supprimerCompte(Compte deleteCompte);
}

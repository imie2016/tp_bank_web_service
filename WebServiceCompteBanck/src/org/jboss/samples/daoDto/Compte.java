package org.jboss.samples.daoDto;

import java.util.List;
import org.jboss.samples.daoDto.*;

public interface Compte {
	List<CompteDao> listerCompte(Proprietaire proprio);
	boolean ajouterCompte(Proprietaire proprio, Compte newCompte);
	boolean modifierCompte(Compte updateCompte);
	boolean supprimerCompte(Compte deleteCompte);
}

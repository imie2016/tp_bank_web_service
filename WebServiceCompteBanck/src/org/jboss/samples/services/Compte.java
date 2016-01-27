package org.jboss.samples.services;

import java.util.List;
import org.jboss.samples.daoDto.*;

public interface Compte {
	List<CompteDao> listerCompte(Proprietaire proprio);
	String ajouterCompte(Proprietaire proprio, Compte newCompte);
	String modifierCompte(Compte updateCompte);
	String supprimerCompte(Compte deleteCompte);
}

package org.jboss.samples.daoDto;

import java.util.List;

public interface CompteImpl {
	List<CompteDTO> findAll();
	List<CompteDTO> findByProprio(ProprietaireDTO proprio);
	CompteDTO findById(Integer id);
	boolean create(CompteDTO compte);
	boolean update(CompteDTO compte);
	boolean delete(CompteDTO compte);
	boolean transactionDepot(CompteDTO compte, Integer montant);
	boolean transactionRetrait(CompteDTO compte, Integer montant);
}

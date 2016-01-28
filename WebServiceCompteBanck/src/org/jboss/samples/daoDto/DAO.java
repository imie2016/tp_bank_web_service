package org.jboss.samples.daoDto;

import java.sql.Connection;
import java.util.List;

public abstract class DAO <T>{
	
	protected Connection conn;
	
	public DAO(Connection conn){
		this.conn = conn;
	}
	
	public abstract List<CompteDTO>  findAllCompte();
	
	public abstract List<CompteDTO> findByProprio(ProprietaireDTO proprio);
	
	public abstract List<ProprietaireDTO> findAllProprio();
	
	public abstract CompteDTO  findByIdCompte(Integer id);
	
	public abstract ProprietaireDTO findByIdProprio(Integer id);
	
	public abstract boolean  createCompte(CompteDTO compte);
	
	public abstract boolean  createProprio(ProprietaireDTO proprio);
	
	public abstract boolean  updateCompte(CompteDTO compte);
	
	public abstract boolean  updateProprio(ProprietaireDTO proprio);
	
	public abstract boolean  deleteCompte(CompteDTO compte);
	
	public abstract boolean  deleteProprio(ProprietaireDTO proprio);
	
	public abstract boolean transactionRetrait(CompteDTO compte, Integer montant);
	
	public abstract boolean transactionDepot(CompteDTO compte, Integer montant);
	
	
}

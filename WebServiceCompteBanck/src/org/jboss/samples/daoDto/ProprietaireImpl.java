package org.jboss.samples.daoDto;

import java.util.List;

public interface ProprietaireImpl {
	List<ProprietaireDTO> findAll();
	ProprietaireDTO findById(Integer id);
	boolean create(ProprietaireDTO Proprietaire);
	boolean update(ProprietaireDTO Proprietaire);
	boolean delete(ProprietaireDTO Proprietaire);
	
}

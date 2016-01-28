package org.jboss.samples.daoDto;

import java.util.List;

public interface ProprietaireImpl {
	List<CompteDTO> findAll();
	CompteDTO findById(Integer id);
	boolean create(CompteDTO compte);
	boolean update(CompteDTO compte);
	boolean delete(CompteDTO compte);
}

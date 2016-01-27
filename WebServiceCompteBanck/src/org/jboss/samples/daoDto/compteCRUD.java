package org.jboss.samples.daoDto;

import java.util.List;

public interface compteCRUD {
	List<CompteImpl> findAll();
	CompteImpl findById(Integer id);
	boolean create(CompteImpl compte);
	boolean update(CompteImpl compte);
	boolean delete(CompteImpl compte);

}

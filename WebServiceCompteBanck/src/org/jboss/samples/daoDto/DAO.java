package org.jboss.samples.daoDto;

import java.sql.Connection;
import java.util.List;

public abstract class DAO <T>{
	
	protected Connection conn;
	
	public DAO(Connection conn){
		this.conn = conn;
	}
	
	public abstract List<CompteDTO>  findAll();
	
	public abstract List<CompteDTO>  findById(Integer id);
	
	public abstract boolean  create(CompteDTO compte);
	
	public abstract boolean  update(CompteDTO compte);
	
	public abstract boolean  delete(CompteDTO compte);

}

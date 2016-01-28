package org.jboss.samples.webservices;

import org.jboss.samples.daoDto.CompteDTO;
import org.jboss.samples.daoDto.CompteDao;
import org.jboss.samples.daoDto.DAO;
import org.jboss.samples.daoDto.DAOConnection;

public class Test {

	public static void main(String[] args) {
		
		//CompteImpl comptee = new CompteDT
		// FAIRE LE TEST INSERT ICI ???
				
		DAO<CompteDTO> test = new CompteDao(DAOConnection.getInstance());
		System.out.println(test.findById(2));

	}

}

package org.jboss.samples.webservices;

import org.jboss.samples.daoDto.CompteDao;
import org.jboss.samples.daoDto.CompteImpl;
import org.jboss.samples.daoDto.DAOConnection;
import org.jboss.samples.services.CompteCTRL;

public class Test {

	public static void main(String[] args) {
		
		//CompteImpl comptee = new CompteDT
		// FAIRE LE TEST INSERT ICI ???
				
				
		//TEST DE LA CONNEXION
		//DAOFactory.getInstance();
		CompteImpl test = new CompteDao();
		
		//test.findAll();
		//test.findById(1);
		test.create();
	}

}

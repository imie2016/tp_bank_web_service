package org.jboss.samples.webservices;

import java.util.ArrayList;
import java.util.List;

import org.jboss.samples.daoDto.CompteDTO;
import org.jboss.samples.daoDto.CompteDao;
import org.jboss.samples.daoDto.CompteImpl;
import org.jboss.samples.daoDto.DAOFactory;


public class Test2 {

	public static void main(String[] args) {
		
		//*************** TEST DE LA PARTIE COMPTE DAO ***************
		//CompteDTO newCompte = new CompteDTO(null, 999, 1);
		//TEST DE LA CONNEXION
		//DAOFactory.getInstance();
		//CompteImpl test = new CompteDao();
		//test.findAll();
		//test.create(newCompte);
		
		
		
		CompteImpl test = new CompteDao();
		
		
		
			//System.out.println(test.findById(2).get);
		
		
		//TEST UPDATE
//		CompteDTO newCompte = test.findById(1);
//		System.out.println(newCompte.getId());
//		newCompte.setSolde(-999);
//		test.update(newCompte);
		
//		test.delete(newCompte);
		//*************** FIN TEST DE LA PARTIE COMPTE DAO ***************
		
	}

}

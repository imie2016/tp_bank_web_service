package org.jboss.samples.webservices;

import org.jboss.samples.daoDto.CompteDTO;
import org.jboss.samples.daoDto.CompteDao;
import org.jboss.samples.daoDto.CompteImpl;


public class Test {

	public static void main(String[] args) {
		
		//CompteDTO newCompte = new CompteDTO(null, 999, 1);

		//TEST DE LA CONNEXION
		//DAOFactory.getInstance();
		CompteImpl test = new CompteDao();
		//test.findAll();
		//test.create(newCompte);
		
		
		//TEST UPDATE
		CompteDTO newCompte = test.findById(1);
//		System.out.println(newCompte.getId());
//		newCompte.setSolde(-999);
//		test.update(newCompte);
		
		test.delete(newCompte);
	}

}

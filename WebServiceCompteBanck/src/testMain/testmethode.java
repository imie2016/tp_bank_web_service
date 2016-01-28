package testMain;

import java.util.List;

import org.jboss.samples.daoDto.CompteDTO;
import org.jboss.samples.daoDto.CompteDao;
import org.jboss.samples.daoDto.DAO;
import org.jboss.samples.daoDto.DAOConnection;
import org.jboss.samples.webservices.Banck;

public class testmethode {

	public static void main(String[] args) {
		Banck bank = new Banck();
		bank.testConnexion();
		
		DAO<CompteDTO> compteDao = new CompteDao(DAOConnection.getInstance());
			List<CompteDTO>compteResult = compteDao.findAll();
		for(CompteDTO compte : compteResult){
			System.out.println("l'id compte "+compte.getId()+" le solde "+compte.getSolde()+" l'id du proprio "+compte.getProprietaires_id());
		}
	}

}

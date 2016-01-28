package org.jboss.samples.daoDto;

import java.io.Serializable;

public class CompteDTO implements Serializable{

	private static final long serialVersionUID = 463411314624812925L;
	private Integer id;
	private Integer solde;
	private Integer proprietaires_id;

	public CompteDTO(Integer id, Integer solde, Integer proprietaires_id) {
		super();
		//this.daoFactory = daoFactory;
		this.id = id;
		this.solde = solde;
		this.proprietaires_id = proprietaires_id;
	}
	
	public Integer getId() {
		return id;
	}
	public Integer getSolde() {
		return solde;
	}
	public Integer getProprietaires_id() {
		return proprietaires_id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setSolde(Integer solde) {
		this.solde = solde;
	}
	public void setProprietaires_id(Integer proprietaires_id) {
		this.proprietaires_id = proprietaires_id;
	}
	
}

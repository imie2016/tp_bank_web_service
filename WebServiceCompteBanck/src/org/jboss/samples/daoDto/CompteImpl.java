package org.jboss.samples.daoDto;

public class CompteImpl {
	private Integer id;
	private Integer solde;
	private Integer proprietaires_id;
	
	public CompteImpl(Integer id, Integer solde, Integer proprietaires_id) {
		super();
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

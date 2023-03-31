package tn.esprit.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Vm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdVm")
	private Long IdVm;
	private Long em1;
	private Long em2;
	private Long Idvoyage1;
	private Long Idvoyage2;
	private Long EntrepriseR;
	private Boolean match1;
	
	@JsonIgnore
	@ManyToOne
	private User userE ;
	
	public Vm(Long idVm, Long em1, Long em2, Long EntrepriseR, Boolean match1, User userE,Long Idvoyage1,Long Idvoyage2) {
		super();
		IdVm = idVm;
		this.em1 = em1;
		this.em2 = em2;
		this.EntrepriseR = EntrepriseR;
		this.match1 = match1;
		this.userE = userE;
		this.Idvoyage1=Idvoyage1;
		this.Idvoyage2=Idvoyage2;
	}
	public Vm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdVm() {
		return IdVm;
	}
	public void setIdVm(Long idVm) {
		IdVm = idVm;
	}
	public Long getEm1() {
		return em1;
	}
	public void setEm1(Long em1) {
		this.em1 = em1;
	}
	public Long getEm2() {
		return em2;
	}
	public void setEm2(Long em2) {
		this.em2 = em2;
	}
	public Long getEntrepriseR() {
		return EntrepriseR;
	}
	public void setEntrepriseR(Long entrepriseR) {
		this.EntrepriseR = entrepriseR;
	}
	public Boolean getmatch1() {
		return match1;
	}
	public void setmatch1(Boolean match1) {
		this.match1 = match1;
	}
	public User getuserE() {
		return userE;
	}
	public void setuserE(User userE) {
		this.userE = userE;
	}
	public Long getIdvoyage1() {
		return Idvoyage1;
	}
	public void setIdvoyage1(Long idvoyage1) {
		this.Idvoyage1 = idvoyage1;
	}
	public Long getIdvoyage2() {
		return Idvoyage2;
	}
	public void setIdvoyage2(Long idvoyage2) {
		this.Idvoyage2 = idvoyage2;
	}
	
	

}

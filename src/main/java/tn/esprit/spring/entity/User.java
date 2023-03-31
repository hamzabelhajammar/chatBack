package tn.esprit.spring.entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity



public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String name;
	private String password;
	private String addresse;
	private int connecte;
	private int role ;  // 0 : entreprise   ,   1: employee
	
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
     private List<Voyage> voyage;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Boit_tchat> boit_tchat ;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "userE")
	private List<Vm> Vms ;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL , mappedBy="entreprise")
	private List<User> employees;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private User entreprise;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public List<Voyage> getVoyage() {
		return voyage;
	}

	public void setVoyage(List<Voyage> voyage) {
		this.voyage = voyage;
	}

	public List<Boit_tchat> getBoit_tchat() {
		return boit_tchat;
	}

	public void setBoit_tchat(List<Boit_tchat> boit_tchat) {
		this.boit_tchat = boit_tchat;
	}

	public List<Vm> getVms() {
		return Vms;
	}

	public void setVms(List<Vm> vms) {
		Vms = vms;
	}

	public List<User> getEmployees() {
		return employees;
	}

	public void setEmployees(List<User> employees) {
		this.employees = employees;
	}

	public User getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(User entreprise) {
		this.entreprise = entreprise;
	}

	public User(Long id, String name, String password, String addresse, int role, List<Voyage> voyage,
			List<Boit_tchat> boit_tchat, List<Vm> vms, List<User> employees, User entreprise,int connecte) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.addresse = addresse;
		this.role = role;
		this.voyage = voyage;
		this.boit_tchat = boit_tchat;
		Vms = vms;
		this.employees = employees;
		this.entreprise = entreprise;
		this.connecte=connecte;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getConnecte() {
		return connecte;
	}

	public void setConnecte(int connecte) {
		this.connecte = connecte;
	}
	
	
	}



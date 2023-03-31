
package tn.esprit.spring.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Boit_tchat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IdBoit_tchat")
	private Long IdBoit_tchat;
	private Long e1;
	private Long e2;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "boit_tchat",fetch=FetchType.EAGER)
	private List<Message> message;

	public Long getIdBoit_tchat() {
		return IdBoit_tchat;
	}
	public void setIdBoit_tchat(Long idBoit_tchat) {
		IdBoit_tchat = idBoit_tchat;
	}
	public Long getE1() {
		return e1;
	}
	public void setE1(Long e1) {
		this.e1 = e1;
	}
	public List<Message> getMessage() {
		return message;
	}
	public void setMessage(List<Message> message) {
		this.message = message;
	}
	public Boit_tchat(Long idBoit_tchat, Long e1, List<Message> message, Long e2) {
		super();
		IdBoit_tchat = idBoit_tchat;
		this.e1 = e1;
		this.message = message;
		this.e2 = e2;
	}
	public Boit_tchat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getE2() {
		return e2;
	}
	public void setE2(Long e2) {
		this.e2 = e2;
	}
	
}

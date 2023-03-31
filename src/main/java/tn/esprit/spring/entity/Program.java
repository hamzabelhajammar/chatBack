package tn.esprit.spring.entity;




import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Program {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "IdProgram")
private Long idProgram;
private String Description;
private String image ;
@ManyToOne

Voyage voyage;
public Long getIdProgram() {
	return idProgram;
}
public void setIdProgram(Long idProgram) {
	this.idProgram = idProgram;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Voyage getVoyage() {
	return voyage;
}
public void setVoyage(Voyage voyage) {
	this.voyage = voyage;
}
public Program(Long idProgram, String description, String image, Voyage voyage) {
	super();
	this.idProgram = idProgram;
	Description = description;
	this.image = image;
	this.voyage = voyage;
}
public Program() {
	super();
	// TODO Auto-generated constructor stub
}


}

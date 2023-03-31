package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.User;


public interface Userservice {
	 public void ajouterEmployeeEtAffecterEntreprise(User v, Long IdUser);
	 public  List<User> AllUser();
	 public  User Userbyid(Long IdUser);
	 public void Connecter(Long idUser ,int a);
	 public  List<User> Employeebyiduser(Long IdUser);
}

package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.Userservice;
@CrossOrigin(origins = {"*"})
@RestController
public class Usercontroller {
	@Autowired
	Userservice userservice;
	@PutMapping("/affecterEmployeenentreprise/{IdEntreprise}")
	public void  affecterEmployeeEntreprise(@PathVariable("IdEntreprise") Long IdEntreprise,@RequestBody User Emp) {
		userservice.ajouterEmployeeEtAffecterEntreprise(Emp, IdEntreprise);
	}
	  @GetMapping("/AllUser")
			public List<User> AllUser(){
		  		System.out.println("0");
				return userservice.AllUser();
		    }
	  
	  @GetMapping("/Userbyid/{IdUser}")
		public User Userbyid(@PathVariable("IdUser") Long IdUser ){
			 return userservice.Userbyid(IdUser);
	  }
	  @PutMapping("/Connecter/{IdUser}/{a}")
		public void Connecter(@PathVariable("IdUser") Long IdUser,@PathVariable("a") int a ){
			 userservice.Connecter(IdUser,a);
	  }
	  @GetMapping("/Employeebyiduser/{IdUser}")
		public  List<User> Employeebyiduser(@PathVariable("IdUser") Long IdUser ){
			 return userservice.Employeebyiduser(IdUser);
	  
	  	}
}

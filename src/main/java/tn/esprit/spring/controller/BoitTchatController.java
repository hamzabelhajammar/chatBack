package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Boit_tchat;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Vm;
import tn.esprit.spring.entity.Voyage;
import tn.esprit.spring.service.BoitTchatService;
import tn.esprit.spring.service.Userservice;
import tn.esprit.spring.service.Vmservice;
import tn.esprit.spring.service.Voyageservice;
@CrossOrigin(origins = {"*"})
@RestController
public class BoitTchatController {
	@Autowired
	BoitTchatService BoitTchatServ ;
	@Autowired
	Vmservice vmservice;
	
	@PutMapping("/ajouterBoit/{IdEmployee1}/{IdEmployee2}")
	public void  ajouterBoit(@PathVariable("IdEmployee1") Long IdUser1,@PathVariable("IdEmployee2") Long IdUser2) {
		
		BoitTchatServ.ajouterBoit(IdUser1, IdUser2);	
  	}
	@GetMapping("/AllBoitUser/{IdEmployee}")
	public List<Boit_tchat> AllBoitUser(@PathVariable("IdEmployee") Long IdUser){
		 return BoitTchatServ.AllBoitUser(IdUser);
  }
	
	 @PostMapping("/ajouterInvitationEtAffecterEntreprise/{IdVoyage}_{IdVoyage2}/{IdUser}")
		public void ajouterInvitationEtAffecterEntreprise( @PathVariable("IdVoyage") String IdVoyage,@PathVariable("IdVoyage2") String IdVoyage2,@PathVariable("IdUser") String IdUser, @RequestBody Vm vm ){
				System.out.println(IdUser);
				System.out.println("bbbbbbbbbbbbbbbbbbbbbb  "+vm.getIdvoyage1());
				vm.setIdvoyage1(Long.parseLong(IdVoyage));
				vm.setIdvoyage2(Long.parseLong(IdVoyage2));
		        vmservice.ajouterInvitationEtAffecterEntreprise(vm,Long.parseLong(IdVoyage),Long.parseLong(IdUser));	
		}
	
	
	
	@GetMapping("/AllAmis/{IdEmployee}")
	public List<User> AllAmis(@PathVariable("IdEmployee") Long IdUser){
		 return BoitTchatServ.AllAmis(IdUser);
  }
	
	 @GetMapping("/GetVmUser/{IdUser}")
		public List<Vm> GetVmUser(@PathVariable("IdUser") Long IdUser){
			 return vmservice.GetVmUser(IdUser);
	    }
	
	@GetMapping("/BoitIdUsers/{IdUser1}_{IdUser2}")
	public Long BoitIdUsers(@PathVariable("IdUser1") Long IdUser1,@PathVariable("IdUser2")Long IdUser2) {
		return BoitTchatServ.BoitIdUsers(IdUser1,IdUser2);
	}
	
	@GetMapping("/GetUserId/{IdUser}")
	public User GetUserId(@PathVariable("IdUser") Long IdUser) {
		return vmservice.GetUserId(IdUser);
	}
	
}

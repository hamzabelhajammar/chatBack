package tn.esprit.spring.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Vm;
import tn.esprit.spring.entity.Voyage;
import tn.esprit.spring.repository.Voyagerepo;
import tn.esprit.spring.service.Vmservice;
import tn.esprit.spring.service.Voyageservice;
@CrossOrigin(origins = {"*"})

@RestController

public class Voyagecontroller {
	@Autowired
	Voyageservice voyageservice ;
	  @PostMapping(value="/addVoyage", consumes = MediaType.APPLICATION_JSON_VALUE)
	  @ResponseBody
	public  Voyage addVoyage(@RequestBody Voyage voyage) {	
	 voyageservice.addVoyage(voyage);
			
		    return voyage;
}
	  @DeleteMapping("/deletvoyage/{idvoyagee}")
	  	public void deletvoyage(@PathVariable("idvoyagee")  Long idvoyagee){
		  voyageservice.deletvoyage(idvoyagee);
	  	
		}
	  
	  @PutMapping(value="/updateVoyage", consumes = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public Voyage UpdateVoyage(@RequestBody Voyage voyage){
		  System.out.println(voyage.getIdVoyage()+voyage.getDistnation()+voyage.getDuree());
	        return  voyageservice.UpdateVoyage(voyage);
}
	  @GetMapping("/retrieveAllVoyage")
		public List<Voyage> retrieveAllVoyage(){
		  
			 return voyageservice.retrieveAllVoyage();
	  }
	  @GetMapping("/getfindbydistnation/{idVoyage}")
		public List<Voyage> getfindbydistnation (@PathVariable("idVoyage") Long idVoyage) {
		  
		return voyageservice.getfindbydistnation(idVoyage);
	}
	  @RequestMapping(value="/Voyage/distnation")
			public List<String> countdistnation () {
			  
			return voyageservice.countdistnation();
		}
	  @RequestMapping(value="/Voyage/maxdistnationviset")
		public List<String> maxdistnationviset () {
		  
		return voyageservice.maxdistnationviset ();
	}
	  @RequestMapping(value="/Voyage/mindistnationviset")
			public List<String> mindistnationviset () {
			  
			return voyageservice.mindistnationviset ();


	  }
	  @RequestMapping(value="/addDataBaseVoyage")
	public  void ajoutBaseDonnee() {	
	 try {
		voyageservice.ajoutBaseDonnee();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		System.out.println("errrreeeurr");
		e.printStackTrace();
	}
	 
		}
	  @PostMapping("/ajouterVoyageEtAffecterEmployee/{IdEmployee}")
		public void  ajouterVoyageEtAffecterEmployee( @RequestBody Voyage v,@PathVariable("IdEmployee") Long IdUser) {
		  System.out.println("222");
		 	voyageservice.ajouterVoyageEtAffecterEmployee(v, IdUser);	
	  	}

	  @GetMapping("/Voyagebyid/{employee_id}")
				public List<Voyage>  Voyagebyid(@PathVariable("employee_id") Long employee_id){
					 return (List<Voyage>)voyageservice.Voyagebyid(employee_id);
	  			}
	  
	  @GetMapping("/FindVoyage/{voyageId}")
		public Voyage  FindVoyage(@PathVariable("voyageId") Long voyageId){
			 return (Voyage)voyageservice.FindVoyage(voyageId);
		}
	  
	  @GetMapping("/GetNames/{voyageId}")
		public List<String>  GetNames(@PathVariable("voyageId") Long voyageId){
			 return voyageservice.GetNames(voyageId);
		}
	  @GetMapping("/GetMatches/{voyageId1}_{voyageId2}")
	  
	  public List<Integer>  GetMatches(@PathVariable("voyageId1") Long voyageId1,@PathVariable("voyageId2") Long voyageId2){
			 return voyageservice.GetMatches(voyageId1,voyageId2);
		}
	  
}

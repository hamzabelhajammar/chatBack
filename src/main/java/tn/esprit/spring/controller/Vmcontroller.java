package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Vm;
import tn.esprit.spring.entity.Voyage;
import tn.esprit.spring.service.Vmservice;
@CrossOrigin(origins = {"*"})
@RestController
public class Vmcontroller {
	@Autowired
	Vmservice vmservice;
	

	
	  @GetMapping("/AcceptVm/{vmId}")
		public void AcceptVm(@PathVariable("vmId") Long vmId) {
		  vmservice.AcceptVm(vmId);
		}
	  @DeleteMapping("/RefuserVm/{vmId}")
		public void RefuserVm(@PathVariable("vmId")Long vmId) {
		  vmservice.RefuserVm(vmId);
		}
	  @GetMapping("/GetvoyageVm/{id}")
		public List<Voyage>  GetvoyageVm(@PathVariable("id") Long id){
			 return vmservice.GetvoyageVm(id);
		}
	  
}

package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Program;
import tn.esprit.spring.service.Programservice;

@RestController
public class Programcontroller {
	@Autowired
	Programservice programservice; 
		  @PostMapping(value="/addprogram", consumes = MediaType.APPLICATION_JSON_VALUE)
	  @ResponseBody
	public  Program addProgram(@RequestBody Program program) {	
	 programservice.addProgram(program);
			
		    return program;
}
	  @DeleteMapping("/removeProgram/{IdProgram}")
	    public void removeProgram(@PathVariable("IdProgram") Long IdProgram){
		  programservice.deleteProgram(IdProgram);

	  
	  
	  
}
	  @PutMapping(value="/updateProgram", consumes = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseBody
	    public Program UpdateProgram(@RequestBody Program program){
	        return  programservice.UpdateProgram(program);
}
	  @GetMapping("/retrieveAllProgram")
		public List<Program> retrieveAllProgram(){
			 return programservice.retrieveAllProgram();
	  }

}

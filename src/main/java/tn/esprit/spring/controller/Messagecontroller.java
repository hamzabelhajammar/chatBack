package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Message;
import tn.esprit.spring.service.Messageservice;
@CrossOrigin(origins = {"*"})

@RestController
public class Messagecontroller {
	@Autowired
	Messageservice messageservice;

	/*
	@ResponseBody
	public  Message addMessage(@RequestBody Message message) {	
		messageservice.addMessage(message);

		return message;
	}
	*/

	@DeleteMapping("/admin/removeMessage/{IdMessage}")
	public void removeMessage(@PathVariable("IdMessage") Long IdMessage){
		messageservice.deleteMessage(IdMessage);
	}
	
	@PutMapping("/addMessageToBoit/{idBoite}")
	public void  addMessageToBoit( @RequestBody Message m,@PathVariable("idBoite") Long idBoite) 
	{
	 	messageservice.addMessageToBoit(m, idBoite);	
  	}
	
	@GetMapping("/AllMessageTwoAmis/{idBoite}")
	public List<Message> AllMessageTwoAmis(@PathVariable("idBoite") Long idBoite)
	{
		return messageservice.AllMessageTwoAmis(idBoite);
	}
	@GetMapping("/LastMessage/{idBoite}")
	public Message LastMessage(@PathVariable("idBoite") Long idBoite)
	{
		return messageservice.LastMessage(idBoite);
	}
}

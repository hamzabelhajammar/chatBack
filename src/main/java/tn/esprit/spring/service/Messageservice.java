package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Message;

public interface Messageservice {
	 public Message addMessage(Message message);
	 	public void deleteMessage(Long id);
		public void addMessageToBoit(Message message, Long idBoite);
		public List<Message> AllMessageTwoAmis(Long idBoite);
		public Message LastMessage (Long idBoite) ;

}

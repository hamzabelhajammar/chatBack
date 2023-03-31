package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Boit_tchat;
import tn.esprit.spring.entity.User;

public interface BoitTchatService {

	public void ajouterBoit(Long IdUser1,Long IdUser2);

	public List<Boit_tchat> AllBoitUser(Long IdUser);

	public List<User> AllAmis(Long IdUser);

	public Long BoitIdUsers(Long IdUser1, Long IdUser2);


}

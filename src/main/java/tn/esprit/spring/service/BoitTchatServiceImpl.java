package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.Boit_tchat;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.BoitTchatRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
public class BoitTchatServiceImpl implements BoitTchatService{
	@Autowired
	BoitTchatRepository BoitTchatRepo;
	@Autowired
	UserRepository usrrepo;
	@Override
	public void ajouterBoit(Long IdUser1,Long IdUser2) {
		User employee1 = usrrepo.findById(IdUser1).get(); 
		User employee2 = usrrepo.findById(IdUser2).get(); 
		Boit_tchat b=new Boit_tchat();
		b.setE1(IdUser1);
		b.setE2(IdUser2);
		List<Boit_tchat> Boites1 = employee1.getBoit_tchat(); 
		Boites1.add(b); 
		employee1.setBoit_tchat(Boites1);
		List<Boit_tchat> Boites2 = employee2.getBoit_tchat(); 
		Boites2.add(b); 
		employee2.setBoit_tchat(Boites2);
		BoitTchatRepo.save(b);
	}
	@Override
	public List<Boit_tchat> AllBoitUser(Long IdUser) {
		User employee = usrrepo.findById(IdUser).get(); 
		//List<Boit_tchat> l = (List<Boit_tchat>)BoitTchatRepo.findAll();
		
		return BoitTchatRepo.BoitsUser(IdUser);
	}
	@Override
	public List<User> AllAmis(Long IdUser) {
		User employee = usrrepo.findById(IdUser).get(); 
		List<Boit_tchat> boites = AllBoitUser(IdUser);
		List<User> Amis=new ArrayList<User>();
		for (Boit_tchat b : boites){
			if (b.getE1()==IdUser) {
				User employee2 = usrrepo.findById(b.getE2()).get(); 
				Amis.add(employee2);
			}
			else {
				User employee1 = usrrepo.findById(b.getE1()).get(); 
				Amis.add(employee1);
			}
		}
		//List<Boit_tchat> l = (List<Boit_tchat>)BoitTchatRepo.findAll();
		//List<Boit_tchat> boites =employee.getBoit_tchat();
		return Amis;
	}
	@Override
	public Long BoitIdUsers(Long IdUser1,Long IdUser2) {
		User employee1 = usrrepo.findById(IdUser1).get(); 
		User employee2 = usrrepo.findById(IdUser2).get(); 
		Long idBoite=BoitTchatRepo.findByUsers(IdUser1,IdUser2);
		return idBoite;
	}
}

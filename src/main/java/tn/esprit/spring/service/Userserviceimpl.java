package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;
@Service
public class Userserviceimpl implements Userservice{
	@Autowired
	UserRepository usrrepo;
	@Override
	public void ajouterEmployeeEtAffecterEntreprise(User v, Long IdUser) {
		User entreprise = usrrepo.findById(IdUser).get(); 
		v.setEntreprise(entreprise);
		usrrepo.save(v); 
		List<User> employees = entreprise.getEmployees(); 
		
		employees.add(v); 
		entreprise.setEmployees(employees);
		usrrepo.save(entreprise);
	}
	@Override
	public List<User> AllUser() {
		// TODO Auto-generated method stub
		System.out.println("1");
		List<User> l = (List<User>)usrrepo.findAll();
		
		return l;
		
	}
	@Override
	public User Userbyid(Long IdUser) {
		return usrrepo.findById(IdUser).get();
		
	}
	@Override
	public void Connecter(Long idUser ,int a) {
		User user = usrrepo.findById(idUser).get();
		
		user.setConnecte(a);
		usrrepo.save(user);
	}
	@Override
	public List<User> Employeebyiduser(Long IdUser) {
		// TODO Auto-generated method stub
		User user = usrrepo.findById(IdUser).get();
		return user.getEmployees();
	}
	
}

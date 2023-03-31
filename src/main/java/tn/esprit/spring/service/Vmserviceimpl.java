package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Vm;
import tn.esprit.spring.entity.Voyage;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.Vmrepo;
import tn.esprit.spring.repository.Voyagerepo;

@Service
public class Vmserviceimpl implements Vmservice {
	@Autowired
	Voyagerepo VoyageRepository;
	@Autowired
	UserRepository usrrepo;
	@Autowired
	Vmrepo vmrepo;
	@Autowired
	BoitTchatService BoitTchatServ ;
	
	@Override
	public void ajouterInvitationEtAffecterEntreprise( Vm vm, Long IdVoyage, Long IdUser) {
		User UserE=usrrepo.findById(IdUser).get();
		
		
		vm.setmatch1(false);
		vm.setuserE(UserE);
		vm.setEntrepriseR(IdUser);
		List<Vm> vms = UserE.getVms();
		vms.add(vm);
		UserE.setVms(vms);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaa  "+vm.getIdvoyage1());
		vmrepo.save(vm);
	}
	@Override
	public List<Vm> GetVmUser(Long IdUser) {
		User Entreprise = usrrepo.findById(IdUser).get();
		return Entreprise.getVms();
		
	}
	@Override
	public void AcceptVm(Long vmId) {
		Vm vm = vmrepo.findById(vmId).get();
		vm.setmatch1(true);
		vmrepo.save(vm);
		RefuserVm(vmId);
		BoitTchatServ.ajouterBoit(vm.getEm1(),vm.getEm2());
		
	}
	@Override
	public void RefuserVm(Long vmId) {
		Vm vm = vmrepo.findById(vmId).get();
		vmrepo.delete(vm);
	}
	@Override
	public User GetUserId(Long id){
		return usrrepo.findById(id).get();
	}
	@Override
	public List<Voyage> GetvoyageVm(Long id) {
		User Entreprise = usrrepo.findById(id).get();
		List<Voyage> voyages=new ArrayList<Voyage>();
		for (Vm vm : Entreprise.getVms()) {
			
			Voyage v1=VoyageRepository.findById(vm.getIdvoyage1()).get();
			Voyage v2=VoyageRepository.findById(vm.getIdvoyage2()).get();
			if (v1.getIdVoyage()==vm.getIdvoyage1() ){
				voyages.add(v2);
			}
			else {
				voyages.add(v1);
			}
		}
		return voyages;
		
	}

}

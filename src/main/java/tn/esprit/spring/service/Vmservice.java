package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Vm;
import tn.esprit.spring.entity.Voyage;

public interface Vmservice {
	public void ajouterInvitationEtAffecterEntreprise(Vm vm, Long IdVoyage, Long IdUser) ;

	public List<Vm> GetVmUser(Long IdUser);

	public void AcceptVm(Long vmId);

	public void RefuserVm(Long vmId);

	public User GetUserId(Long id);

	public List<Voyage> GetvoyageVm(Long id);

}

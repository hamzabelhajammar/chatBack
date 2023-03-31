package tn.esprit.spring.service;

import java.text.ParseException;
import java.util.List;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Voyage;

public interface Voyageservice {
	public Voyage addVoyage(Voyage voyage);

	public Voyage UpdateVoyage(Voyage Voyage);
	public  List<Voyage> retrieveAllVoyage();
	public List<Voyage> getfindbydistnation (Long  idVoyage);
	public List<String> countdistnation ();
	public List<String> maxdistnationviset ();
	public List<String> mindistnationviset ();
	public void ajoutBaseDonnee() throws ParseException ;
	public void deletvoyage(Long idvoyagee);
	 public void ajouterVoyageEtAffecterEmployee(Voyage v, Long IdUser) ;
	 public  List<Voyage> Voyagebyid(Long employee_id);
	 public Voyage FindVoyage( Long idvoyagee );

	public List<String> GetNames(Long idvoyagee);
	public List<Integer> GetMatches(Long idvoyagee1,Long idvoyagee2);
}

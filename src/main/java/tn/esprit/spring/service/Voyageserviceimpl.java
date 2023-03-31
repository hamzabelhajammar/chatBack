package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Objet_de_voyage;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.Vm;
import tn.esprit.spring.entity.Voyage;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.Vmrepo;
import tn.esprit.spring.repository.Voyagerepo;
@Service
public class Voyageserviceimpl implements Voyageservice {
	@Autowired
	Voyagerepo VoyageRepository;
	@Autowired
	UserRepository usrrepo;
	


	



	@Override
	public Voyage UpdateVoyage(Voyage voyage) {
		// TODO Auto-generated method stub
		Voyage newVoyage = VoyageRepository.findById(voyage.getIdVoyage()).get(); 
		newVoyage.setDistnation(voyage.getDistnation());
	newVoyage.setDate(voyage.getDate());
		newVoyage.setDuree(voyage.getDuree());
		newVoyage.setImage(voyage.getImage());
		newVoyage.setObjet_de_voyage(voyage.getObjet_de_voyage());
		newVoyage.setDiscription(voyage.getDiscription());
		return VoyageRepository.save(newVoyage);
}

	@Override
	public List<Voyage> retrieveAllVoyage() {
		// TODO Auto-generated method stub
		return (List<Voyage>) VoyageRepository.findAll();
	
	}



	@Override
	public List<Voyage> getfindbydistnation(Long  idVoyage) {
		Voyage v=VoyageRepository.findById(idVoyage).get();
		System.out.println(v.getDistnation()+v.getIdVoyage());
		return VoyageRepository.findbydistnation(v.getDistnation(),v.getIdVoyage());
		// TODO Auto-generated method stub
		
	}



	@Override
	public List<String> countdistnation() {
		// TODO Auto-generated method stub
		return VoyageRepository.countdistnation();
	}



	@Override
	public List<String> maxdistnationviset() {
		// TODO Auto-generated method stub
		int max=0;
		List<String> names=new ArrayList<String>();
		for (String e :countdistnation()){
			String count_str=e.substring(e.indexOf(",")+1,e.length()) ;
			
			int count=Integer.parseInt(count_str);
			if (count>max){
				max=count;
			}
		}
		for (String e :countdistnation()){
			String count_str=e.substring(e.indexOf(",")+1,e.length()) ;
			
			int count=Integer.parseInt(count_str);
			if (count==max){
				names.add(e.substring(0, e.indexOf(","))+","+count_str);
			}
		}
		return names; 
	}


	@Scheduled(fixedRate=10000)
	@Override
	public List<String> mindistnationviset() {
		List<String> cd=countdistnation();
		int min=Integer.parseInt(cd.get(0).substring(cd.get(0).indexOf(",")+1,cd.get(0).length())); 
		List<String> names=new ArrayList<String>();
		for (String e :cd){
			String count_str=e.substring(e.indexOf(",")+1,e.length()) ;
                         
			
			int count=Integer.parseInt(count_str);

			if (																																																																																																																																																																																														count<min){
				min=count;
			}
		}
		for (String e :cd){
			String count_str=e.substring(e.indexOf(",")+1,e.length()) ;
			
			int count=Integer.parseInt(count_str);
			if (count==min){
				names.add(e.substring(0, e.indexOf(","))+","+count_str);
			}
		
		}
		return names; 
	}



	

	/*
	 public void ajouterVoyageEtAffecterEntreprise(voyage v, Long IdUser) {
			// TODO Auto-generated method stub
			
			User entreprise = UserRepository.findById(IdUser).get(); 
			v.setUser(entreprise);
			VoyageRepository.save(v); 
			List<Voyage> voyages = entreprise.getVoyages(); 
			
			entreprise.add(v); 
			entreprise.setVoyages(voyages);
			UserRepository.save(entreprise);*/



	@Override
	public void ajoutBaseDonnee() throws ParseException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		List<String> distinations=new ArrayList<String>();
		distinations.add("paris");
		distinations.add("germany");
		distinations.add("USA");
		distinations.add("USA");
		distinations.add("tunisie");
		distinations.add("spain");
		distinations.add("tunisie");
		distinations.add("paris");
		distinations.add("poland");
		distinations.add("tunisie");
		distinations.add("poland");
		distinations.add("spain");
		distinations.add("paris");
		distinations.add("spain");
		distinations.add("spain");
		distinations.add("paris");
		distinations.add("paris");
		
		List<Date> dates=new ArrayList<Date>();
		SimpleDateFormat DateFor = new SimpleDateFormat("yyyy/MM/dd");
		
		Date date=DateFor.parse("2022/03/29");
		dates.add(date);
		Date date1=DateFor.parse("2022/04/29");
		dates.add(date1);
		Date date2=DateFor.parse("2022/04/29");
		dates.add(date2);
		Date date3=DateFor.parse("2022/04/5");
		dates.add(date3);
		Date date4=DateFor.parse("2022/04/6");
		dates.add(date4);
		Date date5=DateFor.parse("2022/04/7");
		dates.add(date5);
		Date date6=DateFor.parse("2022/04/8");
		dates.add(date6);
		Date date7=DateFor.parse("2022/04/9");
		dates.add(date7);
		Date date8=DateFor.parse("2022/04/7");
		dates.add(date8);
		Date date9=DateFor.parse("2022/04/8");
		dates.add(date9);
		Date date10=DateFor.parse("2022/04/9");
		dates.add(date10);
		Date date11=DateFor.parse("2022/04/2");
		dates.add(date11);
		Date date12=DateFor.parse("2022/04/6");
		dates.add(date12);
		Date date13=DateFor.parse("2022/04/15");
		dates.add(date13);
		Date date14=DateFor.parse("2022/03/29");
		dates.add(date14);
		Date date15=DateFor.parse("2022/03/28");
		dates.add(date15);
		Date date16=DateFor.parse("2022/03/31");
		dates.add(date16);
		
		List<Integer> duree=new ArrayList<Integer>();
		duree.add(5);
		duree.add(10);
		duree.add(7);
		duree.add(9);
		duree.add(8);
		duree.add(2);
		duree.add(7);
		duree.add(15);
		duree.add(6);
		duree.add(8);
		duree.add(9);
		duree.add(1);
		duree.add(1);
		duree.add(2);
		duree.add(8);
		duree.add(5);
		duree.add(3);
		
		List<String> objets=new ArrayList<String>();
		objets.add("VISITE_ENTREPRISE");
		objets.add("VISITE_ENTREPRISE");
		objets.add("SEMINAIRE");
		objets.add("SEMINAIRE");
		objets.add("SEMINAIRE");
		objets.add("VISITE_ENTREPRISE");
		objets.add("SEMINAIRE");
		objets.add("VISITE_ENTREPRISE");
		objets.add("SEMINAIRE");
		objets.add("VISITE_ENTREPRISE");
		objets.add("SEMINAIRE");
		objets.add("VISITE_ENTREPRISE");
		objets.add("SEMINAIRE");
		objets.add("SEMINAIRE");
		objets.add("SEMINAIRE");
		objets.add("VISITE_ENTREPRISE");
		objets.add("VISITE_ENTREPRISE");
		for (int i=0;i<17;i++){
			System.out.println(i);
			Voyage v=new Voyage();
			v.setDate(dates.get(i));
			v.setDistnation(distinations.get(i));
			v.setDuree(duree.get(i));
			//Objet_de_voyage o=new Objet_de_voyage();
			v.setObjet_de_voyage(Objet_de_voyage.valueOf(objets.get(i)));
			Voyage v2=addVoyage(v);
		
			
		}
		
	}

	@Override
	public Voyage addVoyage(Voyage voyage) {

		// TODO Auto-generated method stub
		VoyageRepository.save(voyage);
		return voyage;
	
	}

	@Override
	public void deletvoyage(Long idvoyagee) {
		// TODO Auto-generated method stub
		VoyageRepository.deleteById(idvoyagee);
		
	}





	@Override
	public void ajouterVoyageEtAffecterEmployee(Voyage v, Long IdUser)  {
		System.out.println("111");
		
		
		User Employee = usrrepo.findById(IdUser).get(); 
		v.setEmployee(Employee);
		VoyageRepository.save(v); 
		List<Voyage> voyages = Employee.getVoyage(); 
		voyages.add(v); 
		Employee.setVoyage(voyages);
		
	}

	@Override
		public List<Voyage> Voyagebyid(Long employee_id) {
			User Employee = usrrepo.findById(employee_id).get(); 
			
			return  Employee.getVoyage();





}

	@Override
	public Voyage FindVoyage(Long idvoyagee) {
		// TODO Auto-generated method stub
		return VoyageRepository.findById(idvoyagee).get();
	}		 
	@Override
	public List<String> GetNames(Long idvoyagee) {
		// TODO Auto-generated method stub
		Voyage v=VoyageRepository.findById(idvoyagee).get();
		String nameEntreprise=v.getEmployee().getEntreprise().getName();
		String nameEmployee=v.getEmployee().getName();
		String idEntreprise=v.getEmployee().getEntreprise().getId().toString();
		String idEmployee=v.getEmployee().getId().toString();
		List<String> names=new ArrayList<String>();
		names.add(nameEmployee);
		names.add(nameEntreprise);
		names.add(idEntreprise);
		names.add(idEmployee);
		return names;
	}	
	public List<Integer> GetMatches(Long idvoyagee1,Long idvoyagee2) {
		// TODO Auto-generated method stub
		Voyage v1=VoyageRepository.findById(idvoyagee1).get();
		Voyage v2=VoyageRepository.findById(idvoyagee2).get();
		User entreprise = v2.getEmployee().getEntreprise(); 
		List<Integer> matches=new ArrayList<Integer>();
		int val=0;
		System.out.println(entreprise.getId());
		for (Vm vm : entreprise.getVms()) {
			System.out.println(vm.getIdvoyage1()+vm.getIdvoyage1()+idvoyagee1+" "+idvoyagee2);
			if ((vm.getIdvoyage1()==idvoyagee1 && vm.getIdvoyage2()==idvoyagee2 ) | (vm.getIdvoyage1()==idvoyagee2 && vm.getIdvoyage2()==idvoyagee1 )){
				matches.add(1);
			}
			else {
				matches.add(0);
			}
		} 
		System.out.println("zzzzzz"+matches.toString());
		return matches;
	}	
}

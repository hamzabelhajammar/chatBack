package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Program;

import tn.esprit.spring.repository.Programrepo;

@Service
public class Programserviceimpl implements Programservice {
	@Autowired
	Programrepo programrepo;

	@Override
	public Program addProgram(Program program) {
		// TODO Auto-generated method stub
		programrepo.save(program);
		return null;
	}

	@Override
	public Program updateProgram(Program program) {
		// TODO Auto-generated method stub
	
			Program newProgram = programrepo.findById(program.getIdProgram()).get(); 
		newProgram.setDescription(program.getDescription());
		newProgram.setImage(program.getImage());
		
		return programrepo.save(newProgram);
	}

	@Override
	public void deleteProgram(Long id) {
		// TODO Auto-generated method stub
		programrepo.deleteById(id);
		
	}

	@Override
	public Program UpdateProgram(Program program) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Program> retrieveAllProgram() {
		// TODO Auto-generated method stub
		return  (List<Program>) programrepo.findAll();
		 
	}

}

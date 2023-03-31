package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Program;

public interface Programservice {
	public Program addProgram(Program program);
	public Program updateProgram(Program program);
	public void deleteProgram(Long id);
	public Program UpdateProgram(Program program);
	public  List<Program> retrieveAllProgram();

}

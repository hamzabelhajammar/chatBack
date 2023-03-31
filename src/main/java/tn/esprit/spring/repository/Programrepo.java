package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entity.Program;


public interface Programrepo extends CrudRepository<Program, Long> {

}

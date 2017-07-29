package com.example.demoSpring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DaoAlumno extends CrudRepository<Alumno, Long> {

	 public Iterable<Alumno> findByNombre(String nombre);
	
}

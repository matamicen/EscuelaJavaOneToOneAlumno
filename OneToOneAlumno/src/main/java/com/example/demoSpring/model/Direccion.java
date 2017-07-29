package com.example.demoSpring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "direcciones")
public class Direccion {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String direccion;
	private String postal;
	private String telefono;
    
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "alumno_id")
	private Alumno alumno;
	
	
	
	public Direccion() {
		super();
	}

	public Direccion(String direccion, String postal, String telefono) {
		super();
		this.direccion = direccion;
		this.postal = postal;
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPostal() {
		return postal;
	}

	public void setPostal(String postal) {
		this.postal = postal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	
	
	

}

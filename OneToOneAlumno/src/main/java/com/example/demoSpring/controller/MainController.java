package com.example.demoSpring.controller;



import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demoSpring.model.Alumno;
import com.example.demoSpring.model.DaoAlumno;
import com.example.demoSpring.model.DaoDirecciones;
import com.example.demoSpring.model.Direccion;


@Controller
public class MainController {
	
	@Autowired
    private DaoAlumno daoAlumno;
	@Autowired
    private DaoDirecciones daoDirecciones;
   
		
		String men = "Hola mundo!";
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		
		@RequestMapping(value="/", method = RequestMethod.GET)
		public String home (Model model)
		{
			
			Alumno alumno = new Alumno();   
	        
	        model.addAttribute("mensaje", men);
	        model.addAttribute("alum",alumno);
			
			return "homepage";
		}
		
		@RequestMapping(value="/createalumno", method = RequestMethod.POST)
		public String doingPost(Model model, @ModelAttribute Alumno alum) //, @RequestParam String comment)
		//public String indexReq(Model model, @ModelAttribute Libro libro, String autor)
		{
			//System.out.println(alum.getNombre() + alum.getApellido() + alum.getEdad());
			//listaAlumnos.add(alum);
		     //model.addAttribute("listaalum",listaAlumnos);
			 Direccion dire = new Direccion("Santa Fe 2334","1425","48045654");
			 
			 dire.setAlumno(alum);
			 alum.setDireccion(dire);
			// daoDirecciones.save(dire);
			
		     daoAlumno.save(alum);
		     Iterable<Alumno> listaBase = daoAlumno.findAll();
		     for(Alumno al: listaBase)
		     {
		    	 System.out.println("nombre:" + al.getNombre() + " Apellido:" +al.getApellido());
		     }
		     model.addAttribute("listaalum",listaBase);
		     
		 //    System.out.println("findOne:"+daoAlumno.findOne((long)3).getNombre());
		     //System.out.println("findbyNombre:"+daoAlumno.findByNombre("jose").getApellido());
		     Iterable<Alumno> listaNombres = daoAlumno.findByNombre("jose"); 
		     for(Alumno al: listaNombres)
		     {
		    	 System.out.println("nombre:" + al.getNombre() + " Apellido:" +al.getApellido());
		     }
		    
			
			return "agregado";
		}
		
		@RequestMapping(value="/deletealumno", method = RequestMethod.GET)
		public String deleteAlumno (Model model, @RequestParam long id)
		{
			daoAlumno.delete(id);
			Iterable<Alumno> list = daoAlumno.findAll();
			
			      
	        
	        model.addAttribute("listaalum", list);
			
			return "agregado";
		}
		
		
		@RequestMapping(value="/addlist", method = RequestMethod.GET)
		public String addlist ()
		{
			
			      
	        
	      //  model.addAttribute("mensaje", men);
			
			return "addlist";
		}
		
	

	}

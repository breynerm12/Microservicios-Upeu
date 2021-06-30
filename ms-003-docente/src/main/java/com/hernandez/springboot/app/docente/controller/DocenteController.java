package com.hernandez.springboot.app.docente.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hernandez.springboot.app.commons.models.entity.Docente;
import com.hernandez.springboot.app.docente.models.service.IDocenteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class DocenteController {
	@Autowired
	private Environment env;
	
	
	
	@Autowired
private IDocenteService docenteService;
	
	@GetMapping("/docentes")
	public List<Docente> listar(){
		return docenteService.findAll().stream().map(docente ->{
		return docente;
		}).collect(Collectors.toList());
	}
	
	
	
	@GetMapping("/docentes/{id}")
	public Docente detalle(@PathVariable Long id) throws Exception {
		Docente docente= docenteService.findById(id);
		return docente;
	}
	
	@PostMapping("/docentes")
	@ResponseStatus(HttpStatus.CREATED)
	public Docente crear(@RequestBody Docente docente) {
		return docenteService.save(docente);
		
	}
	
	@PutMapping("/docentes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Docente editar (@RequestBody Docente docente, @PathVariable Long id) {
		Docente docenteDb = docenteService.findById(id);
		
		
		docenteDb.setNombre(docente.getNombre());//se cambia segun los atributos
		docenteDb.setApellidos(docente.getApellidos());
		docenteDb.setCorreo(docente.getCorreo());
		docenteDb.setTelefono(docente.getTelefono());
		docenteDb.setCodigo(docente.getCodigo());
		docenteDb.setDni(docente.getDni());
		
		return docenteService.save(docenteDb);
				
	}
	
	@DeleteMapping("/docentes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void  eliminar ( @PathVariable Long id) {
		docenteService.deleteById(id);
	}
}

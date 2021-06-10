package com.hernandez.springboot.app.docente.models.service;

import java.util.List;

import com.hernandez.springboot.app.commons.models.entity.Docente;




public interface IDocenteService {

	public List<Docente> findAll(); //para obtener la lista completa
	public Docente findById(Long id);
	
	public Docente save(Docente docente);
	
	public void deleteById(Long id);
}

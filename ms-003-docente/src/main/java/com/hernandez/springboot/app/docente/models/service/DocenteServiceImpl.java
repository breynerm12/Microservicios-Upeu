package com.hernandez.springboot.app.docente.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hernandez.springboot.app.commons.models.entity.Docente;
import com.hernandez.springboot.app.docente.models.dao.DocenteDao;


@Service
public class DocenteServiceImpl implements IDocenteService{

	
	@Autowired
	private DocenteDao docenteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Docente> findAll() {
		return (List<Docente>) docenteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Docente findById(Long id) {
		return  docenteDao.findById(id).orElse(null);
	}

	@Override
	public Docente save(Docente docente) {
		return docenteDao.save(docente);
	}

	@Override
	public void deleteById(Long id) {
		docenteDao.deleteById(id);
		
	}
	
}

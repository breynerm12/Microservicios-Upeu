package com.hernandez.springboot.app.docente.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hernandez.springboot.app.commons.models.entity.Docente;



public interface DocenteDao  extends CrudRepository<Docente, Long>{

}

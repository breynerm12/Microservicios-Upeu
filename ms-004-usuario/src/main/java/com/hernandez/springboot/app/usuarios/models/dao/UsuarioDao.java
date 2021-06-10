package com.hernandez.springboot.app.usuarios.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hernandez.springboot.app.commons.models.entity.Usuario;



public interface UsuarioDao extends CrudRepository<Usuario, Long>{

}

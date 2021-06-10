package com.hernandez.spring.rolesUsu.service;

import java.util.List;

import com.hernandez.spring.rolesUsu.models.RolUsuario;
import com.hernandez.springboot.app.commons.models.entity.Usuario;




public interface RolusuService {

	public List<RolUsuario> findAll();
	public RolUsuario findById(Long id, Integer cantidad);
	
	public Usuario save(Usuario usuario);
	
	public Usuario update(Usuario usuario, Long id);
	
	public void delete(Long id);
}

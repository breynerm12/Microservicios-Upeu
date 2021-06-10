package com.hernandez.springboot.app.usuarios.models.service;

import java.util.List;

import com.hernandez.springboot.app.commons.models.entity.Usuario;



public interface IUsuarioService {
	public List<Usuario> findAll();
	public Usuario findById(Long id);
	
	public Usuario save(Usuario usuario);
	
	public void deleteById(Long id);
}

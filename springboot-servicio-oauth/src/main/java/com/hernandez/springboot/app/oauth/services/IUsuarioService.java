package com.hernandez.springboot.app.oauth.services;

import com.hernandez.springboot.app.commons.models.entity.Usuario;

public interface IUsuarioService {
	 public Usuario findByUsername(String username);

	    public Usuario update(Usuario usuario, Long id);
}

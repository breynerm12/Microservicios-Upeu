package com.hernandez.spring.rolesUsu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hernandez.spring.rolesUsu.models.RolUsuario;
import com.hernandez.spring.rolesUsu.usuarios.RolUsuarioRest;
import com.hernandez.springboot.app.commons.models.entity.Usuario;



@Service("serviceFeign")
public class RolusuServiceFeign implements RolusuService{

	@Autowired
	private RolUsuarioRest usuarioFeign;

	@Override
	public List<RolUsuario> findAll() {
		return usuarioFeign.listar().stream().map(p -> new RolUsuario(p, 1, false)).collect(Collectors.toList());
	}

	@Override
	public RolUsuario findById(Long id, Integer cantidad) {
		return new RolUsuario(usuarioFeign.detalle(id), cantidad, false);
		
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioFeign.crear(usuario);
	}

	@Override
	public Usuario update(Usuario usuario, Long id) {
		return usuarioFeign.update(usuario, id);
	}

	@Override
	public void delete(Long id) {
		usuarioFeign.eliminar(id);
	}
}

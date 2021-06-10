package com.hernandez.spring.rolesUsu.models;

import com.hernandez.springboot.app.commons.models.entity.Usuario;

public class RolUsuario {

	private Usuario usuario;
	private Integer cantidad;

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public RolUsuario(Usuario usuario, Integer cantidad, boolean estado) {
	
		this.usuario = usuario;
		this.cantidad = cantidad;
		
	}
	
	public RolUsuario() {
	}


	
}

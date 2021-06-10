package com.hernandez.springboot.app.commons.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity //indicamos que es una entidad
@Table(name="productos") //nombre de la tabla. ´pertenece a persitencia de  java
public class Producto implements Serializable { //sereializable permite convertir el objeto en paith y queremos guardar nuestro objeto en un sesion http
	

	
   @Id //indicamos que es una llave primaria
   @GeneratedValue(strategy = GenerationType.IDENTITY) //llave autoincremental
	private Long id;
	private String nombre; //columnas que se mapean de forma automatica
	private Double precio;
	@Column(name= "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	@Transient
	private Integer port;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}

	private static final long serialVersionUID = -4679113632747177751L;
}

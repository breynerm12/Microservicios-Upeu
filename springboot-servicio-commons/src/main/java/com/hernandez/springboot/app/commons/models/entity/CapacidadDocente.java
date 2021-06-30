package com.hernandez.springboot.app.commons.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="capacidades_Docente")
public class CapacidadDocente implements Serializable{


	

	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String requisitos;
		private String recCapacidadD;
		private String DocenteParcial;
		private String ClaseModelo;
		private String Cosmovision;
		private String IntegracionFe;
		private String ServicioApren;
		private String Estado;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getRequisitos() {
			return requisitos;
		}
		public void setRequisitos(String requisitos) {
			this.requisitos = requisitos;
		}
		public String getRecCapacidadD() {
			return recCapacidadD;
		}
		public void setRecCapacidadD(String recCapacidadD) {
			this.recCapacidadD = recCapacidadD;
		}
		public String getDocenteParcial() {
			return DocenteParcial;
		}
		public void setDocenteParcial(String docenteParcial) {
			DocenteParcial = docenteParcial;
		}
		public String getClaseModelo() {
			return ClaseModelo;
		}
		public void setClaseModelo(String claseModelo) {
			ClaseModelo = claseModelo;
		}
		public String getCosmovision() {
			return Cosmovision;
		}
		public void setCosmovision(String cosmovision) {
			Cosmovision = cosmovision;
		}
		public String getIntegracionFe() {
			return IntegracionFe;
		}
		public void setIntegracionFe(String integracionFe) {
			IntegracionFe = integracionFe;
		}
		public String getServicioApren() {
			return ServicioApren;
		}
		public void setServicioApren(String servicioApren) {
			ServicioApren = servicioApren;
		}
		public String getEstado() {
			return Estado;
		}
		public void setEstado(String estado) {
			Estado = estado;
		}
		
		private static final long serialVersionUID = 716891081983024937L;
}

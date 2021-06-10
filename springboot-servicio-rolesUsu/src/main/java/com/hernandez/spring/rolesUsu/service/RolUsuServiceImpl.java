package com.hernandez.spring.rolesUsu.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hernandez.spring.rolesUsu.models.RolUsuario;
import com.hernandez.springboot.app.commons.models.entity.Usuario;



@Service("serviceRestTemplate")
public class RolUsuServiceImpl implements RolusuService{

	 
		@Autowired
		private RestTemplate rolRest;
		@Override
		public List<RolUsuario> findAll() {
			List<Usuario> usuarios = Arrays.asList(rolRest.getForObject("http://usuarios/listar", Usuario[].class));
			return usuarios.stream().map(p -> new RolUsuario(p, 1, false)).collect(Collectors.toList());
		}

		@Override
		public RolUsuario findById(Long id, Integer cantidad) {
			Map<String, String> pathVariables = new HashMap<String, String>();
			pathVariables.put("id", id.toString());
			Usuario usuario =  rolRest.getForObject("http://usuarios/ver/{id}", Usuario.class, pathVariables );
			
			return new RolUsuario(usuario, cantidad, false);
		}

		@Override
		public Usuario save(Usuario usuario) {
		
		HttpEntity<Usuario> body = new HttpEntity<Usuario>(usuario);	
		ResponseEntity<Usuario>response=  rolRest.exchange("http://usuarios/crear", HttpMethod.POST, body, Usuario.class);
		Usuario usuarioResponse = response.getBody();
		
		
		return usuarioResponse;
		}

		@Override
		public Usuario update(Usuario usuario, Long id) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		
	HttpEntity<Usuario> body= new HttpEntity<Usuario>(usuario);
	ResponseEntity<Usuario> response= rolRest.exchange("http://usuarios/editar/{id}", HttpMethod.PUT, body, Usuario.class, pathVariables);
			return response.getBody();
		}

		@Override
		public void delete(Long id) {
			Map<String, String> pathVariables = new HashMap<String, String>();
			pathVariables.put("id", id.toString());
			rolRest.delete("http://usuarios/eliminar/{id}", pathVariables);
			
		}
}

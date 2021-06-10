package com.hernandez.springboot.app.usuarios.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hernandez.springboot.app.commons.models.entity.Usuario;
import com.hernandez.springboot.app.usuarios.models.service.IUsuarioService;



@RestController
public class UsuarioController {
	@Autowired
	private Environment envi;
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
private IUsuarioService usuarioService;
	
	@GetMapping("/listar-usuario")
	public List<Usuario> listar(){
		return usuarioService.findAll().stream().map(usuario ->{
			usuario.setPort(port);
		return usuario;
		}).collect(Collectors.toList());
	}
	
	
	
	@GetMapping("/ver-usuario/{id}")
	public Usuario detalle(@PathVariable Long id) throws Exception {
		Usuario usuario= usuarioService.findById(id);
		usuario.setPort(port);
		return usuario;
	}
	
	@PostMapping("/crear-usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario crear(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
		
	}
	
	@PutMapping("/editar-usuario/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario editar (@RequestBody Usuario usuario, @PathVariable Long id) {
		Usuario usuarioDb = usuarioService.findById(id);
		
		
		usuarioDb.setNombre(usuario.getNombre());
		usuarioDb.setApellidos(usuario.getApellidos());
		usuarioDb.setCorreo(usuario.getCorreo());
		usuarioDb.setClave(usuario.getClave());
		usuarioDb.setSexo(usuario.isSexo());
		usuarioDb.setDni(usuario.getDni());
		usuarioDb.setTelefono(usuario.getTelefono());
		usuarioDb.setEstado(usuario.isEstado());
		
		
		return usuarioService.save(usuarioDb);
				
	}
	
	@DeleteMapping("/eliminar-usuario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void  eliminar ( @PathVariable Long id) {
		usuarioService.deleteById(id);
	}
}

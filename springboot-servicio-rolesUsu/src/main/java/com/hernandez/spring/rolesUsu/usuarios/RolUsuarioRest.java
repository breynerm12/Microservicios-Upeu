package com.hernandez.spring.rolesUsu.usuarios;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hernandez.springboot.app.commons.models.entity.Usuario;



@FeignClient (name="ms-004-usuario")//
public interface RolUsuarioRest {

@GetMapping("/listar")
public List<Usuario> listar();

@GetMapping("/ver/{id}")
public Usuario detalle(@PathVariable Long id);

@PostMapping("/crear")
public Usuario crear(@RequestBody Usuario usuario);

@PutMapping("/editar/{id}")
public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id);

@DeleteMapping("/eliminar/{id}")
public void eliminar(@PathVariable Long id);
}

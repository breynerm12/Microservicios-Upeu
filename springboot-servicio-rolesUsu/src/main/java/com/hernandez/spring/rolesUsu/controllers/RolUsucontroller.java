package com.hernandez.spring.rolesUsu.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hernandez.spring.rolesUsu.models.RolUsuario;
import com.hernandez.spring.rolesUsu.service.RolusuService;
import com.hernandez.springboot.app.commons.models.entity.Producto;
import com.hernandez.springboot.app.commons.models.entity.Usuario;


@RefreshScope //nos permite actualizar los 
@RestController
public class RolUsucontroller {


	
private static Logger log= LoggerFactory.getLogger(RolUsucontroller.class);

@Autowired
private Environment env;
	
@Autowired  //indicar o calificar algo y se unsan los implementos de esa interfaz
@Qualifier("serviceFeign")    //serviceRestTemplate solo se remplaza tambien y funciona
private RolusuService rolUsuService;

@Value("${configuracion.texto}")
private String texto;

@GetMapping("/listar")
public List<RolUsuario> listar(){
	return rolUsuService.findAll();
	
}

//@HystrixCommand(fallbackMethod ="metodoAlternativo" )//camino alternativo
@GetMapping("/ver/{id}/cantidad/{cantidad}")
public RolUsuario detalle(@PathVariable Long id, @PathVariable Integer cantidad) {//variable ruta se sa para indicar parametros dinamicos.
return rolUsuService.findById(id, cantidad);
}

public RolUsuario metodoAlternativo(Long id, Integer cantidad) {
	RolUsuario Rusuario =new RolUsuario();
	Usuario usuario=new Usuario();
	
	Rusuario.setCantidad(cantidad);
	usuario.setId(id);
	usuario.setNombre("Breyner ");
	usuario.setApellidos("hernandez");
	usuario.setCorreo("breycruz@gmail.com");
	usuario.setClave("123456");
	usuario.setDni("12345678");
	usuario.setTelefono("123456789");
	Rusuario.setUsuario(usuario);
	return Rusuario;
}

@GetMapping("/obtener-config")
public ResponseEntity<?> obtenerConfig(@Value("${server.port}") String puerto){
	
	log.info(texto);
	Map<String, String> json= new HashMap<>();
	json.put("texto", texto);
	json.put("puerto", puerto);
	
	if(env.getActiveProfiles().length>0 && env.getActiveProfiles()[0].equals("dev")) {
		json.put("autor.nombre", env.getProperty("configuracion.autor.nombre"));
		json.put("autor.email", env.getProperty("configuracion.autor.email"));
	}
	
	return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	
}

@PostMapping("/crear")
@ResponseStatus(HttpStatus.CREATED)
public Usuario crear(@RequestBody Usuario usuario) {
	return rolUsuService.save(usuario);
}

@PutMapping("/editar/{id}")
@ResponseStatus(HttpStatus.CREATED)
public Usuario editar(@RequestBody Usuario usuario, @PathVariable Long id) {
	return rolUsuService.update(usuario, id);
}

@DeleteMapping("/eliminar/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void eliminar(@PathVariable Long id) {
	rolUsuService.delete(id);	
}

}

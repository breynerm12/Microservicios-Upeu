package com.hernandez.springboot.app.usuarios.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hernandez.springboot.app.commons.models.entity.Usuario;
import com.hernandez.springboot.app.usuarios.models.dao.UsuarioDao;



@Service
public class UsuarioServiceImpl implements IUsuarioService {


	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return  usuarioDao.findById(id).orElse(null);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	public void deleteById(Long id) {
		usuarioDao.deleteById(id);
		
	}
}

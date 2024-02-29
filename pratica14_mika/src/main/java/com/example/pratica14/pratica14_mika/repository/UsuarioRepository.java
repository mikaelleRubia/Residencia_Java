package com.example.pratica14.pratica14_mika.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pratica14.pratica14_mika.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	List<Usuario>findByName(String name);
}

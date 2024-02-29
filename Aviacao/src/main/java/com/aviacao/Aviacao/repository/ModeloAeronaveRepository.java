package com.aviacao.Aviacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aviacao.Aviacao.model.Modeloaeronave;

public interface ModeloAeronaveRepository  extends JpaRepository<Modeloaeronave, Long >{
	
	List<Modeloaeronave> findByFabricante(String fabricante);
	List<Modeloaeronave> findByNome(String nome);
}

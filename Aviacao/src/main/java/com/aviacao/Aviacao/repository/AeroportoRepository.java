package com.aviacao.Aviacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aviacao.Aviacao.model.Aeroporto;


public interface AeroportoRepository extends JpaRepository<Aeroporto, Long > {
	
}

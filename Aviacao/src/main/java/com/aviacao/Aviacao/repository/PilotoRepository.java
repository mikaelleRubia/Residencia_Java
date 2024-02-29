package com.aviacao.Aviacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aviacao.Aviacao.model.Piloto;

public interface PilotoRepository extends JpaRepository<Piloto, Long >  {
	
	List<Piloto> findByNome(String nome);
}


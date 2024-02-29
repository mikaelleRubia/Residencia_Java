package com.example.pratica14.pratica14_mika.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pratica14.pratica14_mika.model.Concorrente;

public interface ConcorrenteRepository extends JpaRepository<Concorrente, Long>{
	

	List<Concorrente>findByNome(String Nome);
	

}

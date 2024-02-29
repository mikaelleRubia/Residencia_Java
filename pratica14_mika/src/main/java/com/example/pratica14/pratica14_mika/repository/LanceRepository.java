package com.example.pratica14.pratica14_mika.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pratica14.pratica14_mika.model.Lance;
import com.example.pratica14.pratica14_mika.model.Leilao;
import com.example.pratica14.pratica14_mika.model.Concorrente;

public interface LanceRepository extends JpaRepository<Lance, Long>{

	
	List<Lance>findByLeilao(Leilao leilao);
	List<Lance>findByConcorrente(Concorrente concorrente);

}
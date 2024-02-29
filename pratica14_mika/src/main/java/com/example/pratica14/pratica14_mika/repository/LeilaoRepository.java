package com.example.pratica14.pratica14_mika.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pratica14.pratica14_mika.model.Leilao;


public interface  LeilaoRepository extends JpaRepository<Leilao, Long>{
	
	List<Leilao>findByDescricao(String descricao);

}

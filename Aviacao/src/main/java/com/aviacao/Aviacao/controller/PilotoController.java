package com.aviacao.Aviacao.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.aviacao.Aviacao.controller.Form.PilotoForm;
import com.aviacao.Aviacao.model.Piloto;
import com.aviacao.Aviacao.repository.PilotoRepository;
@RestController
@RequestMapping("/piloto/")
public class PilotoController {

	@Autowired
	public PilotoRepository pilotoRepository;
	

	@GetMapping
	public List<Piloto> listaUsarios(String nome) {
		List<Piloto> pilotos;

		if(nome != null) {
			pilotos = (List<Piloto>) pilotoRepository.findByNome(nome);
		}else{
			pilotos = (List<Piloto>) pilotoRepository.findAll();
		}
		return pilotos;
	}
	
	@PostMapping
	public ResponseEntity<Piloto> inserir(@RequestBody PilotoForm pi,
			UriComponentsBuilder uriC) {
		
		Piloto piloto = pi.toPiloto();
		pilotoRepository.save(piloto);

		uriC.path("/usuario/{id}");
		URI uri = uriC.buildAndExpand(piloto.getId()).toUri();
		return ResponseEntity.created(uri).body(piloto);
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<?>  atualizaPiloto(@PathVariable Long id, @RequestBody PilotoForm pi){
		try{
		
			Piloto piloto = pilotoRepository.getReferenceById(id);
			piloto.setNome(pi.getNome());
			piloto.setNumBreve(pi.getNumbreve());
			
			pilotoRepository.save(piloto);
			return ResponseEntity.ok(pi);
			
		}catch (Exception e){
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	
	@DeleteMapping("/")
	public ResponseEntity<?>  deletePilotoNull(){

		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/")
	public ResponseEntity<?>  atualizaPilotoNull(){

		return ResponseEntity.badRequest().build();
	}

	
}

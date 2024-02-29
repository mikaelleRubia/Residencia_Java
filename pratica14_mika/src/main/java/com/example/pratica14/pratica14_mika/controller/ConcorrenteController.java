package com.example.pratica14.pratica14_mika.controller;

import java.net.URI;
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

import com.example.pratica14.pratica14_mika.controller.DTO.ConcorrenteDto;
import com.example.pratica14.pratica14_mika.controller.Form.ConcorrenteForm;
import com.example.pratica14.pratica14_mika.model.Concorrente;
import com.example.pratica14.pratica14_mika.repository.ConcorrenteRepository;

@RestController
@RequestMapping("/concorrente/")
public class ConcorrenteController {
	
	@Autowired
	public ConcorrenteRepository concorrenteRepository;
	
	@GetMapping
	public List<Concorrente> listaconcorrentes(String Nome){

		List<Concorrente>concorrentes;
		if(Nome!= null) {
			concorrentes = (List<Concorrente>) concorrenteRepository.findByNome(Nome);
		}else {
			concorrentes = (List<Concorrente>) concorrenteRepository.findAll();
		}
		return concorrentes;
			

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>  listaConcorrentes(@PathVariable Long id){
		try {
			Concorrente concorrente = concorrenteRepository.getReferenceById(id);
			ConcorrenteDto concorrentedto = new ConcorrenteDto(concorrente.getId(), concorrente.getNome(), concorrente.getCPF());
			return ResponseEntity.ok(concorrentedto);
		}catch (Exception e){
			return ResponseEntity.notFound().build();
		}

	}
	
	
	@PostMapping
	public ResponseEntity<ConcorrenteDto> inserirconcorrente(@RequestBody  ConcorrenteForm concorrenteForm, UriComponentsBuilder uriCB){
		try {
			Concorrente concorrente =  concorrenteForm.criarConcorrente();
			concorrenteRepository.save(concorrente);
			ConcorrenteDto concorrenteDto = new ConcorrenteDto(concorrente.getId(), concorrente.getNome(), concorrente.getCPF());
			uriCB.path("/concorrente/{id}");
			
			URI uri = uriCB.buildAndExpand(concorrente.getId()).toUri();
			return ResponseEntity.created(uri).body(concorrenteDto);
			
			
		}catch(Exception e) {
			
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id,@RequestBody ConcorrenteForm concorrenteForm) {

		try {

			Concorrente concorrente = concorrenteRepository.getReferenceById(id);
			concorrente.setNome(concorrenteForm.getNome());
			concorrente.setCPF(concorrenteForm.getCPF());
			concorrenteRepository.save(concorrente);
			
			ConcorrenteDto concorrenteDto = new ConcorrenteDto(concorrente.getId(), concorrente.getNome(), concorrente.getCPF());
			return ResponseEntity.ok(concorrenteDto);

		}catch (Exception e){
			return ResponseEntity.notFound().build();
		}

		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteConcorrente(@PathVariable Long id){
		try {
			Concorrente concorrente = concorrenteRepository.getReferenceById(id);
			ConcorrenteDto concorrentedto = new ConcorrenteDto(concorrente.getId(), concorrente.getNome(), concorrente.getCPF());
			concorrenteRepository.delete(concorrente);
			return ResponseEntity.ok(concorrentedto);
		}catch (Exception e){
			return ResponseEntity.notFound().build();
		}

	}
	
	@DeleteMapping("/")
	public ResponseEntity<?>  deleteconCorrenteNull(){

		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/")
	public ResponseEntity<?>  atualizaConcorrenteNull(){

		return ResponseEntity.badRequest().build();
	}
	
	
}

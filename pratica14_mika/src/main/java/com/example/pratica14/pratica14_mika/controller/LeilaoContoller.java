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

import com.example.pratica14.pratica14_mika.controller.DTO.LeilaoDto;
import com.example.pratica14.pratica14_mika.controller.Form.LeilaoForm;
import com.example.pratica14.pratica14_mika.model.Leilao;
import com.example.pratica14.pratica14_mika.repository.LeilaoRepository;

@RestController
@RequestMapping("/leilao/")
public class LeilaoContoller {
	
	@Autowired
	public LeilaoRepository leilaoRepository;
	
	@GetMapping
	public List<Leilao> listaleiloes(String descricao){

		List<Leilao>leiloes;
		if(descricao!= null) {
			leiloes = (List<Leilao>) leilaoRepository.findByDescricao(descricao);
		}else {
			leiloes = (List<Leilao>) leilaoRepository.findAll();
		}
		return leiloes;
			

	}
	
	@PostMapping
	public ResponseEntity<LeilaoDto> inserirLeilao(@RequestBody LeilaoForm leilaoform, UriComponentsBuilder uriCB){
		try {
			Leilao leilao =  leilaoform.criarLeilao();
			leilaoRepository.save(leilao);
			LeilaoDto leilaoDto = new LeilaoDto(leilao.getId(), leilao.getDescricao(), leilao.getValorMinimo(), leilao.getStatus());
			uriCB.path("/leilao/{id}");
			
			URI uri = uriCB.buildAndExpand(leilao.getId()).toUri();
			return ResponseEntity.created(uri).body(leilaoDto);
			
			
		}catch(Exception e) {
			
			return null;
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id,@RequestBody LeilaoForm leilaoform) {

		try {

			Leilao leilao = leilaoRepository.getReferenceById(id);
			leilao.setDescricao(leilaoform.getDescricao());
			leilao.setValorMinimo(leilaoform.getValorMinimo());
			leilao.setStatus(leilaoform.getStatus());
			leilaoRepository.save(leilao);
			
			LeilaoDto leilaoDto = new LeilaoDto(leilao.getId(), leilao.getDescricao(), leilao.getValorMinimo(), leilao.getStatus());
			return ResponseEntity.ok(leilaoDto);

		}catch (Exception e){
			return ResponseEntity.notFound().build();
		}

		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>  listaleiloes(@PathVariable Long id){
		try {
			Leilao leilao = leilaoRepository.getReferenceById(id);
			LeilaoDto leilaodto = new LeilaoDto(leilao.getId(), leilao.getDescricao(), leilao.getValorMinimo(), leilao.getStatus());
			return ResponseEntity.ok(leilaodto);
		}catch (Exception e){
			return ResponseEntity.notFound().build();
		}

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteLeilao(@PathVariable Long id){
		try {
			Leilao leilao = leilaoRepository.getReferenceById(id);
			LeilaoDto leilaodto = new LeilaoDto(leilao.getId(), leilao.getDescricao(), leilao.getValorMinimo(), leilao.getStatus());
			leilaoRepository.delete(leilao);
			return ResponseEntity.ok(leilaodto);
		}catch (Exception e){
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/")
	public ResponseEntity<?>  deleteLeilaoNull(){

		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/")
	public ResponseEntity<?>  atualizaLeilaoNull(){

		return ResponseEntity.badRequest().build();
	}
	
}

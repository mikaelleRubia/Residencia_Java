package com.example.pratica14.pratica14_mika.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.example.pratica14.pratica14_mika.controller.DTO.LanceDto;
import com.example.pratica14.pratica14_mika.controller.DTO.LeilaoDto;
import com.example.pratica14.pratica14_mika.controller.Form.LanceForm;
import com.example.pratica14.pratica14_mika.model.Concorrente;
import com.example.pratica14.pratica14_mika.model.Lance;
import com.example.pratica14.pratica14_mika.model.Leilao;
import com.example.pratica14.pratica14_mika.repository.ConcorrenteRepository;
import com.example.pratica14.pratica14_mika.repository.LanceRepository;
import com.example.pratica14.pratica14_mika.repository.LeilaoRepository;

@RestController
@RequestMapping("/lance/")
public class LanceController {

	
    @Autowired
    private LanceRepository lanceRepository;
    
    
	@Autowired
	public LeilaoRepository leilaoRepository;
	
	@Autowired
	public ConcorrenteRepository concorrenteRepository;
	

	@GetMapping("/vencedorleilao/{id}")
	public ResponseEntity<?> vencedorLeilao(@PathVariable Long id) {
	    try {

	        if (id == null) {
	            return ResponseEntity.badRequest().build();
	        }

	        java.util.Optional<Leilao> leilaoOptional = leilaoRepository.findById(id);
	        

	        if (leilaoOptional.isPresent()) {
	            Leilao leilao = leilaoOptional.get();
	            

	            if (leilao.getStatus().equals("Fechado")) {
	                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	            }
	            
	            List<Lance> lances = lanceRepository.findByLeilao(leilao);
	            
	            if (!lances.isEmpty()) {
	                Lance lanceVencedor = lances.stream()
	                        .max(Comparator.comparingDouble(Lance::getValor))
	                        .orElseThrow(NoSuchElementException::new);
	                

	                Concorrente concorrente = lanceVencedor.getConcorrente();
	               
	                ConcorrenteDto concorrenteDTO = new ConcorrenteDto();
	                concorrenteDTO.setId(concorrente.getId());
	                concorrenteDTO.setNome(concorrente.getNome());
	                concorrenteDTO.setCPF(concorrente.getCPF());

	                Map<String, Object> responseData = new HashMap<>();
	                responseData.put("leilao", leilao);
	                responseData.put("maiorLance", lanceVencedor.getValor());
	                responseData.put("concorrente", concorrenteDTO);
	                
	                return ResponseEntity.ok(responseData);
	            } else {
	                return ResponseEntity.notFound().build();
	            }
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}


    
    @GetMapping
    public ResponseEntity<?> listarLances(Double valor, Long leilao, Long concorrente) {
    	List<Lance> lances;
    
    	if(concorrente != null && leilao == null) {
    		try {
	    		Concorrente conc = concorrenteRepository.getReferenceById(concorrente);
	    		System.out.println(conc.getNome());
    			
	    		lances = (List<Lance>) lanceRepository.findByConcorrente(conc);
       		}catch (Exception e){
    			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    		}
    		
    	}else if(leilao != null && concorrente == null) {
    		try {
    			Leilao leiloes = leilaoRepository.getReferenceById(leilao);
    			System.out.println(leiloes.getStatus());
    			if (leiloes.getStatus().equals("Aberto")) {
    				lances = (List<Lance>) lanceRepository.findByLeilao(leiloes);
    				
    			}else {
    				return ResponseEntity.notFound().build();
    			}
    			
    		}catch (Exception e){
    			return ResponseEntity.badRequest().build();
    		}

    		
    	}else if(leilao == null && concorrente == null) {
    		lances = (List<Lance>) lanceRepository.findAll();
    		
    	}else {
    		lances = new ArrayList<>();
    	}
    	
    	return ResponseEntity.ok(lances);
        
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<?> encontrarLancePorId(@PathVariable Long id) {
		try {
			

			Lance lance = lanceRepository.getReferenceById(id);
			LanceDto lanceDto = new LanceDto(lance.getId(),lance.getLeilao(), lance.getConcorrente(), lance.getValor());
			return ResponseEntity.ok(lanceDto);
			
		}catch (Exception e){
			return ResponseEntity.notFound().build();
		}
	}
    
	@PostMapping
	public ResponseEntity<?> inserirLance(@RequestBody  LanceForm lanceForm, UriComponentsBuilder uriCB){
		try {
			Lance lance =  lanceForm.criarLance();
			lanceRepository.save(lance);
			LanceDto lanceDto = new LanceDto(lance.getId(), lance.getLeilao(), lance.getConcorrente(),lance.getValor());
			uriCB.path("/lance/{id}");
			
			URI uri = uriCB.buildAndExpand(lance.getId()).toUri();
			return ResponseEntity.created(uri).body(lanceDto);
			
			
		}catch(Exception e) {
			
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id,@RequestBody LanceForm lanceForm) {

		try {

			Lance lance = lanceRepository.getReferenceById(id);
			
			
		    try{
	            Concorrente conc = concorrenteRepository.getReferenceById(lanceForm.getConcorrente().getId());
	            System.out.println(conc.getNome());
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	        }
    		
   	
	        try{
	            Leilao leiloes = leilaoRepository.getReferenceById(lanceForm.getLeilao().getId());
	            System.out.println(leiloes.getStatus());
	            
	        }catch (Exception e){
	        	return ResponseEntity.badRequest().build();
	        }
    		
    		
			if(lance.getLeilao().getStatus().equals("Aberto")) {
				
				lance.setLeilao(lanceForm.getLeilao());
				lance.setConcorrente(lanceForm.getConcorrente());
				lance.setValor(lanceForm.getValor());
				lanceRepository.save(lance);
				
				LanceDto lanceDto = new LanceDto(lance.getId(), lance.getLeilao(), lance.getConcorrente(),lance.getValor());
				return ResponseEntity.ok(lanceDto);
				
			}else {
				return ResponseEntity.notFound().build();
			}

		}catch (Exception e){
			return ResponseEntity.notFound().build();
		}

		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteLance(@PathVariable Long id){
		try {
			Lance lance = lanceRepository.getReferenceById(id);
			if(lance.getLeilao().getStatus().equals("Aberto")) {
				LanceDto lancedto = new LanceDto(lance.getId(), lance.getLeilao(), lance.getConcorrente(),lance.getValor());
				lanceRepository.delete(lance);
				return ResponseEntity.ok(lancedto);
				
			}else {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
			}
		}catch (Exception e){
			return ResponseEntity.notFound().build();
		}

	}
	
	@DeleteMapping("/")
	public ResponseEntity<?>  deleteLanceNull(){

		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/")
	public ResponseEntity<?>  atualizaLanceNull(){

		return ResponseEntity.badRequest().build();
	}
	
	
    
    
    
}

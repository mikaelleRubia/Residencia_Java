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

import com.example.pratica14.pratica14_mika.controller.DTO.UsuarioDto;
import com.example.pratica14.pratica14_mika.controller.Form.UsuarioForm;
import com.example.pratica14.pratica14_mika.model.Usuario;
import com.example.pratica14.pratica14_mika.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario/")
public class UsuarioController {
	
	@Autowired
	public UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> listaUsuarios(String name){
		
		List<Usuario>usuarios;
		if(name!= null) {
			usuarios = (List<Usuario>) usuarioRepository.findByName(name);
		}else {
			usuarios = (List<Usuario>) usuarioRepository.findAll();
		}
		return usuarios;
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDto> inserirUsuario(@RequestBody UsuarioForm usuarioform, UriComponentsBuilder uriCB){
		try {
			Usuario usuario =  usuarioform.criarUsuario();
			usuarioRepository.save(usuario);
			UsuarioDto usuariodto = new UsuarioDto(usuario.getId(), usuario.getName(), usuario.getEmail());
			uriCB.path("/usuario/{id}");
			
			URI uri = uriCB.buildAndExpand(usuario.getId()).toUri();
			return ResponseEntity.created(uri).body(usuariodto);
			
			
		}catch(Exception e) {
			
			return null;
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> atualizar(@PathVariable Long id,@RequestBody UsuarioForm usuarioform) {

		try {

			Usuario usuario = usuarioRepository.getReferenceById(id);
			usuario.setName(usuarioform.getName());
			usuario.setEmail(usuarioform.getEmail());
			usuario.setSenha(usuarioform.getSenha());
			usuarioRepository.save(usuario);
			
			UsuarioDto usuariodto = new UsuarioDto(usuario.getId(),usuario.getName(), usuario.getEmail());
			return ResponseEntity.ok(usuariodto);

		}catch (Exception e){
			return ResponseEntity.notFound().build();
		}

		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>  listaUsuarios(@PathVariable Long id){
		try {
			Usuario usuario = usuarioRepository.getReferenceById(id);
			UsuarioDto usuariodto = new UsuarioDto(usuario.getId(),usuario.getName(), usuario.getEmail());
			return ResponseEntity.ok(usuariodto);
		}catch (Exception e){
			return ResponseEntity.notFound().build();
		}

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteUsuario(@PathVariable Long id){

		Usuario usuario = usuarioRepository.getReferenceById(id);
		UsuarioDto usuariodto = new UsuarioDto(usuario.getId(),usuario.getName(), usuario.getEmail());
		
		usuarioRepository.delete(usuario);
		return ResponseEntity.ok(null);
	}

	@DeleteMapping("/")
	public ResponseEntity<?>  deleteUsuarioNull(){

		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/")
	public ResponseEntity<?>  atualizaUsuarioNull(){

		return ResponseEntity.badRequest().build();
	}
	

}

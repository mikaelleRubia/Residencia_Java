package com.examplemika.redesocial02.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examplemika.redesocial02.modelo.*;
import com.examplemika.redesocial02.rsa.*;
@RestController
public class UsuarioController {
	
	@RequestMapping("/listausuarios")
	public ArrayList<Usuario> listaUsarios() {
		ArrayList <Usuario> list =  new ArrayList<Usuario>();
		list.add(new Usuario((long) 1, "ana", "ana@gmail.com.br", "123"));
		list.add(new Usuario((long) 1, "pedro", "pedro@gmail.com.br", "147"));
		list.add(new Usuario((long) 1, "carlos", "carlos@gmail.com.br", "6987"));
		
		return list;
		
	}
	@RequestMapping("/gerachavesra")
	public String cripto() {
		RSAGenerator gerador = new RSAGenerator(255);
		gerador.getPrivatekey();
		gerador.getPublickey();
		return gerador.toString();
		
	}
	
	

}

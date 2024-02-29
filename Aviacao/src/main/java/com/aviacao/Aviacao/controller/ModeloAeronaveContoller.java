package com.aviacao.Aviacao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aviacao.Aviacao.model.Modeloaeronave;
import com.aviacao.Aviacao.repository.ModeloAeronaveRepository;
@RequestMapping("/modelos/")
@RestController
public class ModeloAeronaveContoller {
	
	@Autowired
	public ModeloAeronaveRepository modeloAeronaveRepository;
	
	@GetMapping
	public List<Modeloaeronave> listamodeloAero(String nome, String fabricante) {
	    List<Modeloaeronave> modeloAeronave;

	    if (nome != null && fabricante == null) {
	        modeloAeronave = modeloAeronaveRepository.findByNome(nome);
	    } else if (fabricante != null && nome == null) {
	        modeloAeronave = modeloAeronaveRepository.findByFabricante(fabricante);
	    } else if (fabricante == null && nome == null) {
	        modeloAeronave = modeloAeronaveRepository.findAll();
	    } else {
	        modeloAeronave = new ArrayList<>();
	    }

	    return modeloAeronave;
	}

}

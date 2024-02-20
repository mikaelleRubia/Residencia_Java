package com.aviacao.Aviacao.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aviacao.Aviacao.model.Aeroporto;
import com.aviacao.Aviacao.model.ModeloAeronave;
import com.aviacao.Aviacao.model.Piloto;
import com.aviacao.Aviacao.repository.AeroportoRepository;
import com.aviacao.Aviacao.repository.ModeloAeronaveRepository;
import com.aviacao.Aviacao.repository.PilotoRepository;

@RestController
public class AviacaoController {

	@Autowired
	public PilotoRepository pilotoRepository;
	
	@RequestMapping("/listapilotos")
	public ArrayList<Piloto> listaUsarios() {
		ArrayList<Piloto> pilotos = (ArrayList<Piloto>) pilotoRepository.findAll();
		return pilotos;
	}
	
	@Autowired
	public ModeloAeronaveRepository modeloAeronaveRepository;
	
	@RequestMapping("/listamodelos")
	public ArrayList< ModeloAeronave> listamodeloAero() {
		ArrayList< ModeloAeronave>  modeloAeronave = (ArrayList< ModeloAeronave>) modeloAeronaveRepository.findAll();
		return modeloAeronave;
	}
	
	@Autowired
	public AeroportoRepository aeroportoRepository;
	
	@RequestMapping("/listaaeroporto")
	public ArrayList<Aeroporto> listaAeroporto() {
		ArrayList< Aeroporto>  Aeroportos = (ArrayList< Aeroporto>) aeroportoRepository.findAll();
		return Aeroportos;
	}
	
}

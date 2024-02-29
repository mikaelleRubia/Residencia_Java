package com.example.pratica14.pratica14_mika.controller.DTO;

import com.example.pratica14.pratica14_mika.model.Concorrente;
import com.example.pratica14.pratica14_mika.model.Leilao;

public class LanceDto {
	private Long id;
    private Leilao leilao;
    private Concorrente concorrente;
    private double valor;

    
    public LanceDto(Long id, Leilao leilao, Concorrente concorrente, double valor) {
        this.id = id;
        this.leilao = leilao;
        this.concorrente = concorrente;
        this.valor = valor;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Leilao getLeilao() {
        return leilao;
    }

    public void setLeilao(Leilao leilao) {
        this.leilao = leilao;
    }

    public Concorrente getConcorrente() {
        return concorrente;
    }

    public void setConcorrente(Concorrente concorrente) {
        this.concorrente = concorrente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}

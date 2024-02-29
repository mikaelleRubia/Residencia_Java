package com.example.pratica14.pratica14_mika.controller.Form;

import com.example.pratica14.pratica14_mika.model.Concorrente;
import com.example.pratica14.pratica14_mika.model.Lance;
import com.example.pratica14.pratica14_mika.model.Leilao;

public class LanceForm {
    private Leilao leilao;
    private Concorrente concorrente;
    private double valor;

    
    public LanceForm( Leilao leilao, Concorrente concorrente, double valor) {

        this.leilao = leilao;
        this.concorrente = concorrente;
        this.valor = valor;
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
    
    public Lance criarLance() {
    	return new Lance(null, leilao, concorrente, valor);
    }
}

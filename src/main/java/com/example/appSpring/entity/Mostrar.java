package com.example.appSpring.entity;

import lombok.Getter;
import lombok.Setter;

public class Mostrar {

    @Getter @Setter
    private Double media;

    @Getter @Setter
    private Double desvioPadrao;

    @Getter @Setter
    private  Double mediana;

    @Getter @Setter
    private int qtd;

    public Mostrar(){

    }

    public Mostrar(Double media, Double desvioPadrao, Double mediana, int qtd){
        this.media = media;
        this.desvioPadrao = desvioPadrao;
        this.mediana = mediana;
        this.qtd = qtd;
    }
}

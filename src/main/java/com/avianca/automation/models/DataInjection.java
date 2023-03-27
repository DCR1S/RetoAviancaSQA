package com.avianca.automation.models;

import com.github.javafaker.Faker;

import java.util.Locale;

public class DataInjection {

    Faker faker = new Faker(new Locale("es-ES"));

    private String origen, destino;

    public String getOrigen() {
        return this.origen;
    }

    public String getDestino() {
        return this.destino;
    }


    public DataInjection(){
        this.origen = "Cúcuta";
        this.destino = "Bogotá";
    }
}

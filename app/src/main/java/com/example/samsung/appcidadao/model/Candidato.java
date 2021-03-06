package com.example.samsung.appcidadao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Samsung on 02/07/2018.
 */

public class Candidato extends RealmObject implements Serializable {

    @PrimaryKey
    private int id;
    private String nome;
    private String partido;
    private String numeroUrna;
    private String cargo;
    private String numeroVotos;
    private String estado;
    private String municipio;



    public Candidato(int id, String nome, String partido, String numeroUrna, String cargo) {
        this.id = id;
        this.nome = nome;
        this.partido = partido;
        this.numeroUrna = numeroUrna;
        this.cargo = cargo;

    }


    public Candidato(int id,  String nome, String partido, String numeroUrna, String cargo, String numeroVotos, String estado, String municipio) {
        this.id = id;
        this.nome = nome;
        this.partido = partido;
        this.numeroUrna = numeroUrna;
        this.cargo = cargo;
        this.numeroVotos = numeroVotos;
        this.estado = estado;
        this.municipio = municipio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getNumeroUrna() {
        return numeroUrna;
    }

    public void setNumeroUrna(String numeroUrna) {
        this.numeroUrna = numeroUrna;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNumeroVotos() {
        return numeroVotos;
    }

    public void setNumeroVotos(String numeroVotos) {
        this.numeroVotos = numeroVotos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}

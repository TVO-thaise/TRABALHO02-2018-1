package com.example.samsung.appcidadao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Samsung on 02/07/2018.
 */

public class Eleitor extends RealmObject implements Serializable {

    @PrimaryKey
    private int id;
    private String nome;
    private String nomeMae;
    private Date dataNasc;
    private String numeroTit;
    private String zona;
    private String secao;
    private String municipio;


    public Eleitor() {
    }


    public Eleitor(int id, String nome, String numeroTit, String zona, String secao) {
        this.id = id;
        this.nome = nome;
        this.numeroTit = numeroTit;
        this.zona = zona;
        this.secao = secao;

    }


    public Eleitor(int id, String nome, String nomeMae, Date dataNasc,String numeroTit, String zona, String secao, String municipio) {
        this.id = id;
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.dataNasc = dataNasc;
        this.numeroTit = numeroTit;
        this.zona = zona;
        this.secao = secao;
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

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNumeroTit() {
        return numeroTit;
    }

    public void setNumeroTit(String numeroTit) {
        this.numeroTit = numeroTit;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}

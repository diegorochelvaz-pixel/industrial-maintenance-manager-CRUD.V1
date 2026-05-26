package com.diegorochel.maintenance.model;

import com.diegorochel.maintenance.enums.StatusMaquina;


/**
 * @author Diego Rochel
 */

public class Maquina {

    private int id;

    private String nome;

    private String setor;

    private StatusMaquina status;

    private double horasOperacao;

    public Maquina() {
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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public StatusMaquina getStatus() {
        return status;
    }

    public void setStatus(StatusMaquina status) {
        this.status = status;
    }

    public double getHorasOperacao() {
        return horasOperacao;
    }

    public void setHorasOperacao(double horasOperacao) {
        this.horasOperacao = horasOperacao;
    }

    @Override
    public String toString() {

        return "\n===============================" +
                "\nID: " + id +
                "\nNome: " + nome +
                "\nSetor: " + setor +
                "\nStatus: " + status +
                "\nHoras de operação: " + horasOperacao +
                "\n===============================";
    }

}

package com.diegorochel.maintenance.service;

import com.diegorochel.maintenance.enums.StatusMaquina;
import com.diegorochel.maintenance.model.Maquina;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Diego Rochel
 */

public class MaquinaService {
    private List<Maquina> maquinas;
    private int proximoId;

    public MaquinaService() {
        maquinas = new ArrayList<>();
        proximoId = 1;
    }

    public void cadastrarMaquina(Maquina novaMaquina){
        novaMaquina.setId(proximoId);
        proximoId++;
        maquinas.add(novaMaquina);
        System.out.println("Maquina Cadastrada com sucesso!");
        }

    public void listarMaquinas(){
        System.out.println("\n===== MÁQUINAS CADASTRADAS =====");

        if (maquinas.isEmpty()){

            System.out.println("Nenhuma máquina cadastrada.");
            return;
        }

        for(Maquina maquina : maquinas){
            System.out.println(maquina);

        }
    }

    public Maquina buscarMaquinaPorId(int id){
        for(Maquina maquina : maquinas ){
            if(maquina.getId() == id){
               return maquina;
            }
        }
        return null;
    }

    public boolean removerMaquina(int id){

        Maquina maquina = buscarMaquinaPorId(id);

        if(maquina != null){

            maquinas.remove(maquina);
            return true;
        }

        return false;

    }

    public boolean atualizarMaquina(
        int id,
        String nome,
        String setor,
        double horasOperacao,
        StatusMaquina status) {

        Maquina maquina = buscarMaquinaPorId(id);

            if(maquina != null) {
                maquina.setNome(nome);
                maquina.setSetor(setor);
                maquina.setHorasOperacao(horasOperacao);
                maquina.setStatus(status);

                return true;
            }

        return false;

    }
}

package com.diegorochel.maintenance.app;

import com.diegorochel.maintenance.enums.StatusMaquina;
import com.diegorochel.maintenance.model.Maquina;
import com.diegorochel.maintenance.service.MaquinaService;
import java.util.Scanner;
/**
 * @author Diego Rochel
 */

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MaquinaService maquinaService = new MaquinaService();

        boolean executando = true;

        while (executando) {

            System.out.println("\n==============================================");
            System.out.println("      INDUSTRIAL MAINTENANCE MANAGER");
            System.out.println("==============================================");
            System.out.println("1. Cadastrar máquina");
            System.out.println("2. Listar máquinas");
            System.out.println("3. Buscar máquina");
            System.out.println("4. Remover máquina");
            System.out.println("5. Atualizar máquina");
            System.out.println("6. Sair");

            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();

            sc.nextLine();

            switch (opcao){

                case 1:

                    System.out.println("======== Cadastrar Máquina ========");
                    Maquina novaMaquina = new Maquina();

                    System.out.println("Nome: ");
                    String nome = sc.nextLine();
                    novaMaquina.setNome(nome);

                    System.out.println("Setor: ");
                    String setor = sc.nextLine();
                    novaMaquina.setSetor(setor);

                    System.out.println("Horas de operação: ");
                    Double horasOp = sc.nextDouble();
                    sc.nextLine();
                    novaMaquina.setHorasOperacao(horasOp);

                    System.out.println("Qual o status da máquina: ");
                    System.out.println("1. OPERANDO");
                    System.out.println("2. MANUTENÇÃO");
                    System.out.println("3. PARADA");

                    System.out.println("Digite [1, 2, 3] : ");
                    int statusMaquina = sc.nextInt();
                    sc.nextLine();

                    StatusMaquina status = null;

                    switch (statusMaquina){
                        case 1:
                            status = StatusMaquina.OPERANDO;
                            break;

                        case 2:
                            status = StatusMaquina.MANUTENCAO;
                            break;

                        case 3:
                            status = StatusMaquina.PARADA;
                            break;

                        default:
                            System.out.println("Status inválido!");
                            break;
                    }

                    novaMaquina.setStatus(status);
                    maquinaService.cadastrarMaquina(novaMaquina);
                    System.out.println("Maquina Cadastrada!");

                    break;

                case 2:

                    maquinaService.listarMaquinas();
                    break;

                case 3:

                    System.out.println("Digite o id da máquina procurada: ");

                    int idBusca = sc.nextInt();
                    sc.nextLine();

                    Maquina maquinaEncontrada = maquinaService.buscarMaquinaPorId(idBusca);

                    if (maquinaEncontrada != null) {
                        System.out.println(maquinaEncontrada.toString());
                    } else {
                        System.out.println("Máquina não encontrada.");
                    }

                    break;

                case 4:

                    System.out.println("Digite o id da máquina que você quer apagar: ");
                    int idRemover = sc.nextInt();
                    sc.nextLine();

                    boolean removida = maquinaService.removerMaquina(idRemover);

                    if (removida) {

                        System.out.println("Máquina apagada com sucesso.");

                    } else {
                        System.out.println("Máquina não encontrada.");

                    }
                    break;

                case 5:
                    System.out.println("=============== Atualizar máquina ================= ");
                    System.out.println("Digite o id da máquina: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Novo nome: ");
                    String nomeAtualizado = sc.nextLine();

                    System.out.println("Novo setor: ");
                    String setorAtualizado = sc.nextLine();

                    System.out.println("Horas de operação: ");
                    Double horasAtualizado = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Novo status:");
                    System.out.println("1. OPERANDO");
                    System.out.println("2. MANUTENÇÃO");
                    System.out.println("3. PARADA");

                    int statusAtualizado = sc.nextInt();
                    sc.nextLine();
                    StatusMaquina statusAtualizada = null;

                    switch (statusAtualizado){
                        case 1:
                            statusAtualizada = StatusMaquina.OPERANDO;
                            break;

                        case 2:
                            statusAtualizada = StatusMaquina.MANUTENCAO;
                            break;

                        case 3:
                            statusAtualizada = StatusMaquina.PARADA;
                            break;

                        default:
                            System.out.println("Status inválido.");
                            break;

                    }

                    boolean atualizada = maquinaService.atualizarMaquina(idAtualizar,nomeAtualizado,setorAtualizado,horasAtualizado,statusAtualizada);
                    if (atualizada) {
                        System.out.println("Maquina atualizada com sucesso.");
                    } else {
                        System.out.println("Máquina não encontrada.");
                    }

                    break;

                case 6:

                    System.out.println("Encerrando sistema...");

                    executando = false;

                    break;

                default:

                    System.out.println("Opção inválida");
            }

        }

    }


}

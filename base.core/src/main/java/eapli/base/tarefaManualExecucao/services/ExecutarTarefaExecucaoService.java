package eapli.base.tarefaManualExecucao.services;


import eapli.base.tarefaManualExecucao.application.ExecutarTarefaController;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.framework.io.util.Console;

import java.util.List;

public class ExecutarTarefaService {
private final ExecutarTarefaController controller = new ExecutarTarefaController();
        List<TarefaManualExecucao> listaTarefasManualExecucao;
        List<TarefaManualAprovacao>listaTarefaManualAprovacao;
    public boolean mostrarTarefasExecucao(){
        TarefaManualExecucao tarefaManualExecucao = null;
        listaTarefasManualExecucao=controller.tarefasManualExecucaoPendente();
        int index = 1;
        for (TarefaManualExecucao t : listaTarefasManualExecucao) {
            System.out.println(index + " " + t.toString());
            index++;
        }

        boolean escolherTarefa = false;

        while (!escolherTarefa) {
            int opcao = Console.readInteger("Escolha a tarefa que pretende realizar : (prima 0 para sair)");

            if (opcao == 0) {
                return false;
            }else if (opcao <= listaTarefasManualExecucao.size() && opcao > 0) {
                escolherTarefa = true;
                tarefaManualExecucao = listaTarefasManualExecucao.get(opcao - 1);
            }else{
                System.out.println("Coloque um index válido");
            }
        }
        return escolherTarefa;
    }

    public boolean mostrarTarefasAprovacao(){
        TarefaManualAprovacao tarefaManualAprovacao = null;
        listaTarefaManualAprovacao = controller.tarefasManualAprovacao();
        int index = 1;
        for (TarefaManualAprovacao t : listaTarefaManualAprovacao) {
            System.out.println(index + " " + t.toString());
            index++;
        }

        boolean escolherTarefa = false;

        while (!escolherTarefa) {
            int opcao = Console.readInteger("Escolha a tarefa que pretende realizar : (prima 0 para sair)");

            if (opcao == 0) {
                return false;
            }else if (opcao <= listaTarefasManualExecucao.size() && opcao > 0) {
                escolherTarefa = true;
                tarefaManualAprovacao = listaTarefaManualAprovacao.get(opcao - 1);
            }else{
                System.out.println("Coloque um index válido");
            }
        }
        return escolherTarefa;
    }
}


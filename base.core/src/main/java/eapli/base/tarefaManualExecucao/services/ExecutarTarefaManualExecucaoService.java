package eapli.base.tarefaManualExecucao.services;


import eapli.base.tarefaManualAprovacao.application.ExecutarTarefaAprovacaoController;
import eapli.base.tarefaManualExecucao.application.ExecutarTarefaExecucaoController;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.framework.io.util.Console;

import java.util.List;

public class ExecutarTarefaManualExecucaoService {
private final ExecutarTarefaExecucaoController controller = new ExecutarTarefaExecucaoController();
private final ExecutarTarefaAprovacaoController  controllerAPP = new ExecutarTarefaAprovacaoController();

        List<TarefaManualExecucao> listaTarefaManualExecucao;
    public void comecarTarefaManualExec(TarefaManualExecucao tarefa){
 // todo fazer execucacao da tarefa manual
        tarefa.definirMomentoRealizacao();
    }

    public void comentarTarefa(){

    }

    public boolean mostrarTarefasAprovacao(){
        TarefaManualExecucao tarefaManualAprovacao = null;
        listaTarefaManualExecucao = controller.tarefasManualExecucao();
        int index = 1;
        for (TarefaManualExecucao t : listaTarefaManualExecucao) {
            System.out.println(index + " " + t.toString());
            index++;
        }

        boolean escolherTarefa = false;

        while (!escolherTarefa) {
            int opcao = Console.readInteger("Escolha a tarefa que pretende realizar : (prima 0 para sair)");

            if (opcao == 0) {
                return false;
            }else if (opcao <= listaTarefaManualExecucao.size() && opcao > 0) {
                escolherTarefa = true;
                tarefaManualAprovacao = listaTarefaManualExecucao.get(opcao - 1);
            }else{
                System.out.println("Coloque um index válido");
            }
        }
        return escolherTarefa;
    }
}


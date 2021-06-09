package eapli.base.app.common.console.presentation.executarTarefaPendenteUI;

import eapli.base.tarefaManual.application.ExecutarTarefaController;
import eapli.base.tarefaManual.domain.TarefaManualAprovacao;
import eapli.base.tarefaManual.domain.TarefaManualExecucao;
import eapli.base.tarefaManual.services.ExecutarTarefaService;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ExecutarTarefaPendenteUI extends AbstractUI {

    ExecutarTarefaService executarTarefa = new ExecutarTarefaService();

    @Override
    protected boolean doShow() {


        boolean escolherTipo = true;
        while(escolherTipo){
                String opcao = Console.readLine("Escolha o tipo de tarefa que pretende visualizar : (Aprovacao ou Execucao)");

                if (opcao.equalsIgnoreCase("aprovacao")) {
                    //todo mostrar tarefas de aprovacao
                    executarTarefa.mostrarTarefasAprovacao();
                    escolherTipo= false;
                }else if (opcao.equalsIgnoreCase("execucao")) {
                    //todo mostrar tarefas de execucao
                    executarTarefa.mostrarTarefasExecucao();
                }else{
                    System.out.println("Coloque um tipo de tarefa válido");
                }
            }

return true ;
    }


    @Override
    public String headline() {
        return "Escolher tarefa a executar ";
    } }




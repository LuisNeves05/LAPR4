package eapli.base.app.common.console.presentation.executarTarefaPendenteUI;

import eapli.base.tarefaManualExecucao.application.ExecutarTarefaExecucaoController;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.tarefaManualExecucao.services.ExecutarTarefaManualExecucaoService;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.List;

public class ExecutarTarefaManualPendenteUI extends AbstractUI {
    private final ExecutarTarefaExecucaoController controller = new ExecutarTarefaExecucaoController();
    ExecutarTarefaManualExecucaoService executarTarefa = new ExecutarTarefaManualExecucaoService();
    List<TarefaManualExecucao> listaTarefasManualExecucao;

    @Override
    protected boolean doShow() {
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
                    executarTarefa.comecarTarefaManualExec(tarefaManualExecucao);
       // todo se tiver decisao e comment
        //  if (tarefaManualExecucao.)




return true ;
    }


    @Override
    public String headline() {
        return "Escolher tarefa a executar ";
    } }




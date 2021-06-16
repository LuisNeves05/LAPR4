package eapli.base.app.common.console.presentation.assignarTarefaUI;

import eapli.base.Utils.SortValues;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualExecucao.application.AssignarTarefaController;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorio;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorioJPAimpl;
import eapli.base.tarefaManualExecucao.services.AssignarTarefaAlgoritmoService;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class AssignarTarefasUI extends AbstractUI {

    private final AssignarTarefaController controller = new AssignarTarefaController();

    @Override
    protected boolean doShow() {

        TarefaManualExecucao tarefa = null;
        List<TarefaManualExecucao> listaTarefasManualExecucao = controller.tarefasManualExecucao();

        ////////////////////////MY CHANGES /////////////////////////

        AssignarTarefaAlgoritmoService algo = new AssignarTarefaAlgoritmoService();
        algo.selecionarColabComMenosTarefas();

        //////////////////////////////////////////////////////////////

        /*
        if (!listaTarefasManualExecucao.isEmpty()) {
            int index = 1;
            for (TarefaManualExecucao t : listaTarefasManualExecucao) {
                System.out.println(index + " " + t.toString());
                index++;
            }

            boolean escolherTarefa = true;

            while (escolherTarefa) {
                int opcao = Console.readInteger("Escolha a tarefa que pretende realizar : (prima 0 para sair)");

                if (opcao == 0) {
                    return false;
                } else if (opcao <= listaTarefasManualExecucao.size() && opcao > 0) {
                    escolherTarefa = false;
                    tarefa = listaTarefasManualExecucao.get(opcao - 1);
                } else {
                    System.out.println("Coloque um index válido");
                }
            }

            assignarTarefaManualExecucao(tarefa);
            if (controller.assignarTarefaExecutante(tarefa) != null)
                System.out.println("Tarefa reivindicar com sucesso");
        } else {
            System.out.println("Nao existem tarefas por reevindicar");
        }


         */

        return true;
    }


    @Override
    public String headline() {
        return "Reivindicar Tarefa";
    }

    public void assignarTarefaManualExecucao(TarefaManualExecucao tarefa) {
        tarefa.retirarEquipa();
        tarefa.defineColaboradorExecutante(controller.responsavelTarefa());
    }
}

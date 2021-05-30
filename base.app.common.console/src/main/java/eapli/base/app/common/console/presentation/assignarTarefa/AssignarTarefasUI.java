package eapli.base.app.common.console.presentation.assignarTarefa;

import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefaManual.application.AssignarTarefaController;
import eapli.base.tarefaManual.application.QueriesTarefaController;
import eapli.base.tarefaManual.domain.TarefaManualExecucao;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;

import java.util.*;

public class AssignarTarefasUI extends AbstractUI {

    private final AssignarTarefaController controller = new AssignarTarefaController();

    @Override
    protected boolean doShow() {

        TarefaManualExecucao tarefa = null;
        List<Equipa> listaequipas = (List<Equipa>) controller.equipasColab();
        Set<TarefaManualExecucao> setTarefasManualExecucao = new HashSet<>();
        if (listaequipas.isEmpty()) {
            System.out.println("Ainda não têm uma equipa associada.Não pode reivindicar tarefas.");
            return false;
        }
        for (Equipa equipa : listaequipas) {
            setTarefasManualExecucao.addAll((List<TarefaManualExecucao>) controller.tarefasManualExecucao(equipa));

        }


        if (setTarefasManualExecucao.isEmpty()) {
            System.out.println("Não existem tarefas para reivindicar .");
            return false;
        }
        List<TarefaManualExecucao> listaTarefasManualExecucao = new ArrayList<>(setTarefasManualExecucao);

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
            }else if (opcao <= listaTarefasManualExecucao.size() && opcao > 0) {
                escolherTarefa = false;
                tarefa = listaTarefasManualExecucao.get(opcao - 1);
            }else{
                System.out.println("Coloque um index válido");
            }
        }

        assignarTarefaManualExecucao(tarefa);
        if (controller.assignarTarefaExecutante(tarefa) != null)
            System.out.println("Tarefa reivindicar com sucesso");
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

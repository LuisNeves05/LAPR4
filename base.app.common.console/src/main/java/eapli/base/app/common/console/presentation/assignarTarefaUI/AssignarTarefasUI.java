package eapli.base.app.common.console.presentation.assignarTarefaUI;

import ExecutorServer.ClientExecutorSSL;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaAutomatica.persistance.TarefaAutomaticaRepositorio;
import eapli.base.tarefaManualExecucao.application.AssignarTarefaController;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.framework.presentation.console.AbstractUI;

import java.io.IOException;

public class AssignarTarefasUI extends AbstractUI {

    private final AssignarTarefaController controller = new AssignarTarefaController();
    private final FormularioPreenchidoRepositorio repo = PersistenceContext.repositories().formularioPreenchidoRepositorio();
    private final TarefaAutomaticaRepositorio repoT = PersistenceContext.repositories().tarefaAutomaticaRepositorio();
    private final TicketRepositorio repoTick = PersistenceContext.repositories().ticketRepositorio();

    @Override
    protected boolean doShow() {

        ClientExecutorSSL executorSSL = new ClientExecutorSSL();
        try {
            executorSSL.executarTarefaAutomatica();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

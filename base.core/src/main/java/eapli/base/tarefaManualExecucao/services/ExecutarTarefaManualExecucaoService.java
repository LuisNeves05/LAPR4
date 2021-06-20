package eapli.base.tarefaManualExecucao.services;


import eapli.base.colaborador.domain.Colaborador;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualExecucao.domain.EstadoRealizacao;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorio;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.framework.domain.repositories.TransactionalContext;

import java.util.Map;

public class ExecutarTarefaManualExecucaoService {

    private final FormularioPreenchidoRepositorio fpr = PersistenceContext.repositories().formularioPreenchidoRepositorio();
    private final TicketRepositorio ticketRepositorio;
    private final TarefaManualExecucaoRepositorio tarefaExecucaoRepositorio;

    public ExecutarTarefaManualExecucaoService(final TransactionalContext autoTx) {
        ticketRepositorio = PersistenceContext.repositories().ticketRepositorio(autoTx);
        tarefaExecucaoRepositorio = PersistenceContext.repositories().tarefaManualExecucaoRepositorio(autoTx);
    }

    public void executarTarefa(Formulario f, Map<Resposta, Integer> respostas, TarefaManualExecucao tarefaManualExecucao, Colaborador colabPedido) {
        FormularioPreenchido fp = fpr.save(new FormularioPreenchido(f, respostas, colabPedido));
        tarefaManualExecucao.ticketDaTarefa().adicionaFormularioResposta(fp);
        tarefaManualExecucao.ticketDaTarefa().completarTicket();
        tarefaManualExecucao.concluirTarefa();
        tarefaManualExecucao.ticketDaTarefa().definirFinalTicket();
        ticketRepositorio.save(tarefaManualExecucao.ticketDaTarefa());
        tarefaExecucaoRepositorio.save(tarefaManualExecucao);

    }

}


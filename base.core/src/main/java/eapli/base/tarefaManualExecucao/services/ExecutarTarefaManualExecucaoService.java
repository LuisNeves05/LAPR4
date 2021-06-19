package eapli.base.tarefaManualExecucao.services;


import eapli.base.colaborador.domain.Colaborador;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.tarefaManualExecucao.persistance.TarefaManualExecucaoRepositorio;
import eapli.base.ticket.persistence.TicketRepositorio;

import java.util.Map;
import java.util.Set;

public class ExecutarTarefaManualExecucaoService {

    private final FormularioPreenchidoRepositorio fpr = PersistenceContext.repositories().formularioPreenchidoRepositorio();
    private final TicketRepositorio ticketRepositorio = PersistenceContext.repositories().ticketRepositorio();
    private final TarefaManualExecucaoRepositorio tarefaExecucaoRepositorio =  PersistenceContext.repositories().tarefaManualExecucaoRepositorio();

    public void executarTarefa(Formulario f, Map<Resposta, Integer> respostas, TarefaManualExecucao tarefaManualExecucao, Colaborador colabPedido) {
        FormularioPreenchido fp = fpr.save(new FormularioPreenchido(f, respostas, colabPedido));
        tarefaManualExecucao.ticketDaTarefa().adicionaFormularioResposta(fp);
        ticketRepositorio.save(tarefaManualExecucao.ticketDaTarefa());
        tarefaManualExecucao.definirMomentoRealizacao();
        tarefaExecucaoRepositorio.save(tarefaManualExecucao);
    }

    public void comecarTarefaManualExec(TarefaManualExecucao tarefa) {
        // todo fazer execucacao da tarefa manual
        tarefa.definirMomentoRealizacao();
    }


}


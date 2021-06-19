package eapli.base.tarefaManualAprovacao.service;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.base.formularioPreenchido.persistencia.FormularioPreenchidoRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualAprovacao.persistance.TarefaManualAprovacaoRepositorio;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.ticket.persistence.TicketRepositorio;
import eapli.framework.domain.repositories.TransactionalContext;

import java.util.Map;
import java.util.Set;

public class TerminarAprovacaoService {

    private final FormularioPreenchidoRepositorio fpr = PersistenceContext.repositories().formularioPreenchidoRepositorio();

    private final TicketRepositorio ticketRepo;
    private final TarefaManualAprovacaoRepositorio tarefaManualAprovacaoRepositorio;

    public TerminarAprovacaoService(final TransactionalContext autoTx){
        ticketRepo = PersistenceContext.repositories().ticketRepositorio(autoTx);
        tarefaManualAprovacaoRepositorio = PersistenceContext.repositories().tarefaManualAprovacaoRepositorio(autoTx);
    }

    public TarefaManualAprovacao terminaAprovacao(Formulario f, Map<Resposta, Integer> respostas, TarefaManualAprovacao tarefaManualAprovacao, Colaborador colabPedido){
        FormularioPreenchido fp = fpr.save(new FormularioPreenchido(f, respostas, colabPedido));
        tarefaManualAprovacao.ticketDaTarefa().adicionaFormularioResposta(fp);
        tarefaManualAprovacao.ticketDaTarefa().definirFinalAprovacaoTicket();
        ticketRepo.save(tarefaManualAprovacao.ticketDaTarefa());
        return tarefaManualAprovacaoRepositorio.save(tarefaManualAprovacao);
    }
}

package eapli.base.tarefaManualExecucao.services;

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

public class TerminarExecucaoService {

    private final FormularioPreenchidoRepositorio fpr;
    private final TicketRepositorio ticketRepo;
    private final TarefaManualAprovacaoRepositorio tarefaManualAprovacaoRepositorio;

    public TerminarExecucaoService(final TransactionalContext autoTx){
        fpr = PersistenceContext.repositories().formularioPreenchidoRepositorio(autoTx);
        ticketRepo = PersistenceContext.repositories().ticketRepositorio(autoTx);
        tarefaManualAprovacaoRepositorio = PersistenceContext.repositories().tarefaManualAprovacaoRepositorio(autoTx);
    }

    public TarefaManualAprovacao terminaAprovacao(Formulario f, Map<Resposta, Integer> respostas, TarefaManualAprovacao tarefaManualAprovacao, Colaborador colabPedido){
        FormularioPreenchido fp = fpr.save(new FormularioPreenchido(f, respostas, colabPedido));
        tarefaManualAprovacao.ticketDaTarefa().adicionaFormularioResposta(fp);
        ticketRepo.save(tarefaManualAprovacao.ticketDaTarefa());
        tarefaManualAprovacao.definirMomentoAprovacao();
        return tarefaManualAprovacaoRepositorio.save(tarefaManualAprovacao);
    }
}

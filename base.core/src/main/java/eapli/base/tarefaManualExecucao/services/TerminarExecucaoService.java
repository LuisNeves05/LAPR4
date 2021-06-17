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
import java.util.Set;

public class TerminarExecucaoService {

    private final FormularioPreenchidoRepositorio fpr = PersistenceContext.repositories().formularioPreenchidoRepositorio();
    private final TicketRepositorio ticketRepo = PersistenceContext.repositories().ticketRepositorio();
    private final TarefaManualAprovacaoRepositorio tarefaManualAprovacaoRepositorio = PersistenceContext.repositories().tarefaManualAprovacaoRepositorio();

    public TarefaManualAprovacao terminaAprovacao(Formulario f, Set<Resposta> respostas, TarefaManualAprovacao tarefaManualAprovacao, Colaborador colabPedido){
        fpr.save(new FormularioPreenchido(f, respostas, tarefaManualAprovacao.ticketDaTarefa(), colabPedido));
        ticketRepo.save(tarefaManualAprovacao.ticketDaTarefa());
        tarefaManualAprovacao.definirMomentoAprovacao();
        return tarefaManualAprovacaoRepositorio.save(tarefaManualAprovacao);
    }
}

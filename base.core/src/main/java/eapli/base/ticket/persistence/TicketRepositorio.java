package eapli.base.ticket.persistence;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoIdentificador;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Calendar;
import java.util.List;

public interface TicketRepositorio extends DomainRepository<Long, Ticket> {

    Iterable<Ticket> ticketPorColabEmExecucao(Colaborador colab);

    Iterable<Ticket> ticketPorColabConcluido(Colaborador colab);

    List<Ticket> ticketsComFeedbackDoColab(Colaborador colabLogado);

    List<Ticket> ticketsConcluidos(Calendar date);

    Long totalTickets();


    List<Ticket> ticketPelaTarefaAutomatica();
}
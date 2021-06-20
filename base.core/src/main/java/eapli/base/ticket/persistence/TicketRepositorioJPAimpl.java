package eapli.base.ticket.persistence;

import eapli.base.Application;
import eapli.base.colaborador.domain.Colaborador;

import eapli.base.ticket.domain.EstadoTicket;
import eapli.base.tarefaManualExecucao.domain.TarefaManualExecucao;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.Calendar;
import java.util.List;


public class TicketRepositorioJPAimpl extends JpaAutoTxRepository<Ticket, Long, Long>
        implements TicketRepositorio {

    public TicketRepositorioJPAimpl(final TransactionalContext autoTx) {
        super(autoTx, "eapli.base");
    }

    public TicketRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Iterable<Ticket> ticketPorColabEmExecucao(Colaborador colab){
        Query query = super.createQuery("SELECT t from Ticket t where t.colabRequisitou = :colabReq and t.estadoTicket='EM_EXECUCAO' or t.estadoTicket='POR_APROVAR'", Ticket.class);
        query.setParameter("colabReq", colab);
        return query.getResultList();
    }

    @Override
    public Iterable<Ticket> ticketPorColabConcluido(Colaborador colab){
        Query query = super.createQuery("SELECT t from Ticket t where t.colabRequisitou = :colabReq and t.estadoTicket='CONCLUIDO'", Ticket.class);
        query.setParameter("colabReq", colab);
        return query.getResultList();
    }

    @Override
    public List<Ticket> ticketsComFeedbackDoColab(Colaborador colabLogado){
        Query query = super.createQuery("SELECT t from Ticket t where (select s.requerFeedback from Servico s where t.servico = s) = :feedback and  t.colabRequisitou = :colabLogado and t.estadoTicket='CONCLUIDO'", Ticket.class);
        query.setParameter("colabLogado", colabLogado);
        query.setParameter("feedback", true);
        return query.getResultList();
    }

    @Override
    public List<Ticket> ticketsConcluidos(Calendar date) {
        Query query = super.createQuery("SELECT t from Ticket t where t.estadoTicket='CONCLUIDO' and t.dataFimExecucaoTicket > :date", Ticket.class);
        query.setParameter("date",date);
        return query.getResultList();
    }

    @Override
    public Long totalTickets(){
        Query query = super.createQuery("SELECT COUNT(t) from Ticket t",Long.class);
        return (Long) query.getSingleResult();}


    @Override
    public List<Ticket> ticketPelaTarefaAutomatica(){
        Query query = super.createQuery("select t from Ticket t inner join TarefaAutomatica taut on t=taut.ticket", Ticket.class);
        return query.getResultList();
    }


}

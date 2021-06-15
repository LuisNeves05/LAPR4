package eapli.base.ticket.persistence;

import eapli.base.Application;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;


public class TicketRepositorioJPAimpl extends JpaAutoTxRepository<Ticket, Long, Long>
        implements TicketRepositorio {

    public TicketRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Iterable<Ticket> ticketPorColabEmExecucao(Colaborador colab){
        Query query = super.createQuery("SELECT t from Ticket t where t.colabRequisitou = :colabReq and t.estadoTicket='EM_EXECUCAO'", Ticket.class);
        query.setParameter("colabReq", colab);
        return query.getResultList();
    }

    @Override
    public Iterable<Ticket> ticketPorColabConcluido(Colaborador colab){
        Query query = super.createQuery("SELECT t from Ticket t where t.colabRequisitou = :colabReq and t.estadoTicket='CONCLUIDO'", Ticket.class);
        query.setParameter("colabReq", colab);
        return query.getResultList();
    }
}

package eapli.base.ticket.persistence;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.servico.domain.*;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.List;


public class TicketRepositorioJPAimpl extends JpaAutoTxRepository<Ticket, Long, Long>
        implements TicketRepositorio {

    public TicketRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Iterable<Ticket> ticketPorColabEmExecucao(Colaborador colab){
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT t from Ticket t where t.colabRequisitou = :colabReq and t.estadoTicket='EM_EXECUCAO'", Ticket.class);
        query.setParameter("colabReq", colab);
        return query.getResultList();
    }

    @Override
    public Iterable<Ticket> ticketPorColabConcluido(Colaborador colab){
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT t from Ticket t where t.colabRequisitou = :colabReq and t.estadoTicket='CONCLUIDO'", Ticket.class);
        query.setParameter("colabReq", colab);
        return query.getResultList();
    }
}

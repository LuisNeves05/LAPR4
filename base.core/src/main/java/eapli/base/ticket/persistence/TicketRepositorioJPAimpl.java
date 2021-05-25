package eapli.base.ticket.persistence;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.catalogo.domain.Catalogo;
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
}

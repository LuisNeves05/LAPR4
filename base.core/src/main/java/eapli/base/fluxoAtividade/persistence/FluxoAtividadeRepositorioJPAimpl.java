package eapli.base.fluxoAtividade.persistence;

import eapli.base.Application;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;


public class FluxoAtividadeRepositorioJPAimpl extends JpaAutoTxRepository<FluxoAtividade, Long, Long>
        implements FluxoAtividadeRepositorio {

    public FluxoAtividadeRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }
}

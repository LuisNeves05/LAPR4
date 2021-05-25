package eapli.base.tarefaAprovacao.persistance;

import eapli.base.Application;
import eapli.base.tarefaAprovacao.domain.TarefaAprovacao;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;


public class TarefaAprovacaoRepositorioJPAimpl extends JpaAutoTxRepository<TarefaAprovacao, Long, Long>
        implements TarefaAprovacaoRepositorio {

    public TarefaAprovacaoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }
}

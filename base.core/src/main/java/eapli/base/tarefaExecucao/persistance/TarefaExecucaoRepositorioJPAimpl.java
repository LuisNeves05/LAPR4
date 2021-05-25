package eapli.base.tarefaExecucao.persistance;

import eapli.base.Application;
import eapli.base.tarefaExecucao.domain.TarefaExecucao;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;


public class TarefaExecucaoRepositorioJPAimpl extends JpaAutoTxRepository<TarefaExecucao, Long, TarefaExecucao>
        implements TarefaExecucaoRepositorio {

    public TarefaExecucaoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }
}

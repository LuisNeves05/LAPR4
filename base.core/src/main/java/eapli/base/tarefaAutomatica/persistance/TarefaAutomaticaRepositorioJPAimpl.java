package eapli.base.tarefaAutomatica.persistance;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.tarefaAutomatica.domain.TarefaAutomatica;
import eapli.base.ticket.domain.EstadoTicket;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class TarefaAutomaticaRepositorioJPAimpl extends JpaAutoTxRepository<TarefaAutomatica, Long, Long>
        implements TarefaAutomaticaRepositorio {

    public TarefaAutomaticaRepositorioJPAimpl(final TransactionalContext autoTx) {
        super(autoTx, "eapli.base");
    }

    public TarefaAutomaticaRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public List<TarefaAutomatica> tarefasAutomaticasPendentes() {
        //QueryMaker qm = new QueryMaker();
        //qm.criarEntityManager("").createQuery("select t from TarefaAutomatica t inner join Ticket tic on t.ticket=tic where tic.estadoTicket=:emExec");

        Query query = super.createQuery("select t from TarefaAutomatica t inner join Ticket tic on t.ticket=tic where tic.estadoTicket=:emExec", TarefaAutomatica.class);
        query.setParameter("emExec", EstadoTicket.EM_EXECUCAO);
        return query.getResultList();
    }

}

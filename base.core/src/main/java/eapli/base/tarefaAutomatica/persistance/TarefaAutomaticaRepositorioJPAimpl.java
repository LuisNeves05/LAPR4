package eapli.base.tarefaAutomatica.persistance;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.tarefaAutomatica.domain.TarefaAutomatica;
import eapli.base.ticket.domain.EstadoTicket;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;
import java.util.List;


public class TarefaAutomaticaRepositorioJPAimpl extends JpaAutoTxRepository<TarefaAutomatica, Long, Long>
        implements TarefaAutomaticaRepositorio {

    public TarefaAutomaticaRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public List<TarefaAutomatica> tarefasAutomaticasPendentes(){
        Query query = super.createQuery("select t from TarefaAutomatica t inner join Ticket tic on t.ticket=tic where tic.estadoTicket=:emExec", TarefaAutomatica.class);
        query.setParameter("emExec", EstadoTicket.EM_EXECUCAO);
        return query.getResultList();
    }

}

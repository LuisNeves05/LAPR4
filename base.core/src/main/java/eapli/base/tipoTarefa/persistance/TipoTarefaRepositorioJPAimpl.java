package eapli.base.tipoTarefa.persistance;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.servico.domain.Servico;
import eapli.base.ticket.domain.Ticket;
import eapli.base.tipoTarefa.domain.TipoTarefa;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;


public class TipoTarefaRepositorioJPAimpl extends JpaAutoTxRepository<TipoTarefa, Long, Long>
        implements TipoTarefaRepositorio {

    public TipoTarefaRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Iterable<TipoTarefa> tipoTarefaPeloServico(final Servico s){
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT tt from TipoTarefa tt where :servico = tt.servico", Servico.class);
        query.setParameter("servico", s);
        return query.getResultList();
    }
}

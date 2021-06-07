package eapli.base.fluxoAtividade.persistence;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.base.fluxoAtividade.statusFluxo.StatusFluxo;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;


public class FluxoAtividadeRepositorioJPAimpl extends JpaAutoTxRepository<FluxoAtividade, Long, Long>
        implements FluxoAtividadeRepositorio {

    public FluxoAtividadeRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Iterable<FluxoAtividade> fluxosAtivos() {
        QueryMaker qm = new QueryMaker();
        final Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT t from FluxoAtividade t where t.statusFluxo = :a", FluxoAtividade.class);
        query.setParameter("a", StatusFluxo.ATIVO);
        return query.getResultList();
    }

    @Override
    public Iterable<FluxoAtividade> fluxosTotal() {
        QueryMaker qm = new QueryMaker();
        final Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT t from FluxoAtividade t", FluxoAtividade.class);
        return query.getResultList();
    }
}

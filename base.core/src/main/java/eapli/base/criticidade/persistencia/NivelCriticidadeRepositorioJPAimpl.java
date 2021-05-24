package eapli.base.criticidade.persistencia;

import eapli.base.Application;
import eapli.base.Utils.QueryMaker;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import javax.persistence.Query;

public class NivelCriticidadeRepositorioJPAimpl extends JpaAutoTxRepository<NivelCriticidade, Long, Long>
        implements NivelCriticidadeRepositorio {

    public NivelCriticidadeRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }


    @Override
    public Iterable<NivelCriticidade> niveisCritDefault() {
        QueryMaker qm = new QueryMaker();
        Query query = qm.criarEntityManager("eapli.base").createQuery("SELECT nc FROM NivelCriticidade nc where nc.isDefault =true ",
                NivelCriticidade.class);
        return query.getResultList();
    }
}

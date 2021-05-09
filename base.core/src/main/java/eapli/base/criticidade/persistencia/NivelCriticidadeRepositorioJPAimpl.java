package eapli.base.criticidade.persistencia;

import eapli.base.Application;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class NivelCriticidadeRepositorioJPAimpl extends JpaAutoTxRepository<NivelCriticidade, Long, Long>
        implements NivelCriticidadeRepositorio {

    public NivelCriticidadeRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }


}

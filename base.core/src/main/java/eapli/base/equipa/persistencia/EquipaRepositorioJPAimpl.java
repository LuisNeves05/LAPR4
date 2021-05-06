package eapli.base.equipa.persistencia;

import eapli.base.Application;
import eapli.base.equipa.domain.CodigoEquipa;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;


public class EquipaRepositorioJPAimpl extends JpaAutoTxRepository<Equipa, CodigoEquipa, Equipa>
        implements EquipaRepositorio {

    public EquipaRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Equipa findByKeyword(String keyword) {
        return null;
    }
}

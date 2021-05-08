package eapli.base.colaborador.persistencia;

import eapli.base.Application;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.colaborador.domain.Colaborador;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class ColaboradorRepositorioJPAImpl extends JpaAutoTxRepository<Colaborador, MecanographicNumber, MecanographicNumber> implements ColaboradorRepositorio {

    public ColaboradorRepositorioJPAImpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }
}

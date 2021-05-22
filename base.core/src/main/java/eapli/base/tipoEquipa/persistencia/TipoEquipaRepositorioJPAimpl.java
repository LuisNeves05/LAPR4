package eapli.base.tipoEquipa.persistencia;
import eapli.base.Application;
import eapli.base.tipoEquipa.domain.CodigoInterno;
import eapli.base.tipoEquipa.domain.TipoEquipa;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;


public class TipoEquipaRepositorioJPAimpl   extends JpaAutoTxRepository<TipoEquipa, Long, CodigoInterno> implements TipoEquipaRepositorio {
    public TipoEquipaRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }
}

package eapli.base.catalogo.persistencia;

import eapli.base.Application;
import eapli.base.catalogo.domain.Catalogo;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoIdentificador;
import eapli.base.servico.persistencia.ServicoRepositorio;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

public class CatalogoRepositorioJPAimpl extends JpaAutoTxRepository<Catalogo, Long, Long>
        implements CatalogoRepositorio {

    public CatalogoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

}

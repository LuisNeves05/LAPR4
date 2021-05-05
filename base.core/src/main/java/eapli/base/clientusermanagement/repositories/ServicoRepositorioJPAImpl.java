package eapli.base.clientusermanagement.repositories;

import eapli.base.clientusermanagement.domain.Servico;
import eapli.base.clientusermanagement.jpa.JpaRepositorio;

public class ServicoRepositorioJPAImpl extends JpaRepositorio<Servico, Long> implements RepositorioServico {

    @Override
    protected String persistenceUnitName() {
        return "eapli.base";
    }
}



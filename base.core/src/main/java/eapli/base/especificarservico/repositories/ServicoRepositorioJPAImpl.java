package eapli.base.especificarservico.repositories;

import eapli.base.especificarservico.domain.Servico;
import eapli.base.especificarservico.jpa.JpaRepositorioServico;

public class ServicoRepositorioJPAImpl extends JpaRepositorioServico<Servico, Long> implements RepositorioServico {

    /**
     * Unit Name de persistência
     */
    @Override
    protected String persistenceUnitName() {
        return "eapli.base";
    }
}



package eapli.base.atividadeRealizacao.persistence;

import eapli.base.Application;
import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;


public class AtividadeRealizacaoRepositorioJPAimpl extends JpaAutoTxRepository<AtividadeRealizacao, Long, Long>
        implements AtividadeRealizacaoRepositorio {

    public AtividadeRealizacaoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }
}

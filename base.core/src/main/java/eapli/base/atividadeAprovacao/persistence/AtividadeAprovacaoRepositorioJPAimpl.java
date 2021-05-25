package eapli.base.atividadeAprovacao.persistence;

import eapli.base.Application;
import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.fluxoAtividade.domain.FluxoAtividade;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;


public class AtividadeAprovacaoRepositorioJPAimpl extends JpaAutoTxRepository<AtividadeAprovacao, Long, Long>
        implements AtividadeAprovacaoRepositorio {

    public AtividadeAprovacaoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }
}

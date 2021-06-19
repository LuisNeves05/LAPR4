package eapli.base.atividadeAprovacao.persistence;

import eapli.base.Application;
import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


public class AtividadeAprovacaoRepositorioJPAimpl extends JpaAutoTxRepository<AtividadeAprovacao, Long, Long>
        implements AtividadeAprovacaoRepositorio {

    public AtividadeAprovacaoRepositorioJPAimpl(final TransactionalContext autoTx) {
        super(autoTx, "eapli.base");
    }

    public AtividadeAprovacaoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }
}

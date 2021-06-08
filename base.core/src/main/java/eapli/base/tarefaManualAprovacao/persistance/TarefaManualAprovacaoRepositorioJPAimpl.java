package eapli.base.tarefaManualAprovacao.persistance;

import eapli.base.Application;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;


public class TarefaManualAprovacaoRepositorioJPAimpl extends JpaAutoTxRepository<TarefaManualAprovacao, Long, Long>
        implements TarefaManualAprovacaoRepositorio {

    public TarefaManualAprovacaoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }
}

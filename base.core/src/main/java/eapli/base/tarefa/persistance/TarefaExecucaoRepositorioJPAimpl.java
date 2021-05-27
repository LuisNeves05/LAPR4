package eapli.base.tarefa.persistance;

import eapli.base.Application;
import eapli.base.tarefa.domain.TarefaManual;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;


public class TarefaExecucaoRepositorioJPAimpl extends JpaAutoTxRepository<TarefaManual, Long, Long>
        implements TarefaExecucaoRepositorio {

    public TarefaExecucaoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }
}

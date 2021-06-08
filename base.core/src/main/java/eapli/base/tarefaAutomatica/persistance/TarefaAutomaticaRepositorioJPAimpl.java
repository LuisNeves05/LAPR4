package eapli.base.tarefaAutomatica.persistance;

import eapli.base.Application;
import eapli.base.tarefaAutomatica.domain.TarefaAutomatica;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;


public class TarefaAutomaticaRepositorioJPAimpl extends JpaAutoTxRepository<TarefaAutomatica, Long, Long>
        implements TarefaAutomaticaRepositorio {

    public TarefaAutomaticaRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }
}

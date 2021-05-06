package eapli.base.servico.persistencia;

import eapli.base.Application;
import eapli.base.servico.domain.Servico;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;

import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ServicoRepositorioJPAimpl extends JpaAutoTxRepository<Servico, Long, Servico>
        implements ServicoRepositorio {

    public ServicoRepositorioJPAimpl(String puname) {
        super(puname, Application.settings().getExtendedPersistenceProperties(), "eapli.base");
    }

    @Override
    public Servico findByKeyword(String keyword) {
        return null;
    }
}

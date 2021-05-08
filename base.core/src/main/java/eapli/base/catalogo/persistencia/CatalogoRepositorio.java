package eapli.base.catalogo.persistencia;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoIdentificador;
import eapli.framework.domain.repositories.DomainRepository;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

public interface CatalogoRepositorio extends DomainRepository<Long, Catalogo> {

    Iterable<Catalogo> catalogoPorTitulo(final String titulo);

    Iterable<Catalogo> catalogoPorDescBreve(final String descBreve);
}

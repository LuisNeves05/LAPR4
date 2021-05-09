package eapli.base.servico.persistencia;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoIdentificador;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;
import java.util.Optional;

public interface ServicoRepositorio extends DomainRepository<ServicoIdentificador, Servico > {

    List<Servico> servicoPorIdentificador(final String identificador, final Catalogo catalogo);

    List<Servico> servicoPorTitulo(final String titulo, final Catalogo catalogo);

    Iterable<Servico> findByEstado(final String estado);

    List<Servico> servicoPorDescBreve(final String descBreve, final Catalogo catalogo);

    List<Servico> servicoPorKeyword(final String keyword, final Catalogo catalogo);
}
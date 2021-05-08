package eapli.base.servico.persistencia;

import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoIdentificador;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Optional;

public interface ServicoRepositorio extends DomainRepository<ServicoIdentificador, Servico > {

    Iterable<Servico> servicoPorIdentificador(final String identificador);

    Iterable<Servico> servicoPorTitulo(final String titulo);

    public Iterable<Servico> findByEstado(final String estado);

    Iterable<Servico> servicoPorDescBreve(final String descBreve);

    Iterable<Servico> servicoPorKeyword(final String keyword);
}
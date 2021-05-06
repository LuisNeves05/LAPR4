package eapli.base.clientusermanagement.repositories;

import eapli.base.clientusermanagement.domain.ClientUser;
import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.base.clientusermanagement.domain.servico.Servico;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

public interface ServicoRepository
        extends DomainRepository<MecanographicNumber, ClientUser> {

    /**
     * retorna o Servico mediante o titulo
     *
     * @param titulo
     *            the username to search for
     * @return
     */
    Optional<Servico> findByTitulo(String titulo);

    /**
     * retorna o Servico mediante uma Keyword
     *
     * @param keyword
     *            the username to search for
     * @return
     */
    Optional<Servico> findByKeyword(String keyword);

    Iterable<Servico> findAllActive();
}
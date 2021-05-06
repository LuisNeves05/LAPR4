package eapli.base.servico.persistencia;

import eapli.base.clientusermanagement.domain.SignupRequest;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.infrastructure.authz.domain.model.Username;
import eapli.framework.infrastructure.repositories.Repository;

import java.util.List;

public interface ServicoRepositorio extends DomainRepository<Servico, Servico > {

    Servico findByKeyword(String keyword);

}
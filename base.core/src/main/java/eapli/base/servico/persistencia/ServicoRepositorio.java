package eapli.base.servico.persistencia;

import eapli.base.servico.domain.Servico;
import eapli.base.servico.domain.ServicoIdentificador;
import eapli.framework.domain.repositories.DomainRepository;

public interface ServicoRepositorio extends DomainRepository<ServicoIdentificador, Servico > {

    Servico findByKeyword(String keyword);

}
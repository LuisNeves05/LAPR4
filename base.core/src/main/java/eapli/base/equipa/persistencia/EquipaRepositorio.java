package eapli.base.equipa.persistencia;

import eapli.base.equipa.domain.Equipa;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.repositories.DomainRepository;

public interface EquipaRepositorio extends DomainRepository<Equipa, Equipa > {

    Equipa findByKeyword(String keyword);

}
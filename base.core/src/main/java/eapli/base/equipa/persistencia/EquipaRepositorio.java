package eapli.base.equipa.persistencia;

import eapli.base.equipa.domain.Equipa;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.List;

public interface EquipaRepositorio extends DomainRepository<Equipa, Equipa > {

    Equipa findByKeyword(String keyword);

    List<Equipa> listarAcronimosEquipa(String keyword);

}
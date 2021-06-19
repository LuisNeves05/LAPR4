package eapli.base.equipa.persistencia;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.CodigoEquipa;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Collection;
import java.util.List;

public interface EquipaRepositorio extends DomainRepository<CodigoEquipa, Equipa > {

    Equipa findByKeyword(String keyword);

    List<Equipa> listarAcronimosEquipa(String keyword);

    Iterable<Equipa> equipasDoCatalogo(Catalogo catalogo);

    List<Equipa> equipasDoColaborador(Colaborador colaborador);
}
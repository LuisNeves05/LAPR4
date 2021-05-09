package eapli.base.equipa.persistencia;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.equipa.domain.Equipa;
import eapli.framework.domain.repositories.DomainRepository;

import java.util.Collection;
import java.util.List;

public interface EquipaRepositorio extends DomainRepository<Equipa, Equipa > {

    Equipa findByKeyword(String keyword);

    List<Equipa> listarAcronimosEquipa(String keyword);

    List<Catalogo> catalogosPorEquipa(Equipa equipa);

    List<Catalogo> catalogosPorEquipaPorTitulo(final Equipa eq, final String titulo);

    List<Catalogo> catalogosPorEquipaPorDescBreve(final Equipa eq, final String descBreve);
}
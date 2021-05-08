package eapli.base.catalogo.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;

public class PesquisarCatalogoController {

    /**
     * Repositório do Catalogo
     */
    private final CatalogoRepositorio repoCat = PersistenceContext.repositories().catalogoRepositorio();

    public Iterable<Catalogo> pesquisarCatalogoPorTitulo(final String titulo){
        return repoCat.catalogoPorTitulo(titulo);
    }

    public Iterable<Catalogo> pesquisarCatalogoPorDescBreve(final String descbreve){
        return repoCat.catalogoPorDescBreve(descbreve);
    }
}

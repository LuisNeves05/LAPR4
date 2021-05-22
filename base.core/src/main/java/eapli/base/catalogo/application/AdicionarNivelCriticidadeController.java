package eapli.base.catalogo.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.framework.domain.repositories.IntegrityViolationException;
import java.util.List;

public  class AdicionarNivelCriticidadeController {

    private final CatalogoRepositorio repoCatalogo = PersistenceContext.repositories().catalogoRepositorio();


    public List<Catalogo> catalogosSemNivelCrit() {
        return (List<Catalogo>) repoCatalogo.catalogosSemNivelCriticidade();
    }

    public Catalogo addNivelCriticidade(Catalogo catalogo, NivelCriticidade nivelCriticidade) {
        catalogo.adicionarNivelCriticidade(nivelCriticidade);

        try {
            return repoCatalogo.save(catalogo);
        } catch (IntegrityViolationException violation) {
            System.out.println("Erro na persistência do catálogo!");
        }
        return null;
    }
}
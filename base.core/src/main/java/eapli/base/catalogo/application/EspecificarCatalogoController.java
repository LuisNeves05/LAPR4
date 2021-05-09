package eapli.base.catalogo.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.domain.CatalogoBuilder;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.infrastructure.persistence.PersistenceContext;
import java.util.Set;

public class EspecificarCatalogoController {

    /**
     * Repositório do Catalogo
     */
    private final CatalogoRepositorio repoCat = PersistenceContext.repositories().catalogoRepositorio();

    /**
     * Especificação de um novo Catalogo
     */
    public Catalogo especificarCatalogo(String titulo, String descBreve, String descCompleta,
                                        int icon, Colaborador colaborador, Set<Equipa> equipaSet) {

        CatalogoBuilder catalogoBuilder = new CatalogoBuilder();
        catalogoBuilder.comTitulo(titulo).comDescBreve(descBreve).comDescComp(descCompleta)
                .comIcon(new byte[icon]).comColaboradorResponsavel(colaborador).comListaEquipas(equipaSet);

        return this.repoCat.save(catalogoBuilder.build());
    }

}

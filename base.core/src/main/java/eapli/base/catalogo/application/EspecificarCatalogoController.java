package eapli.base.catalogo.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.catalogo.persistencia.CatalogoRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Keyword;
import eapli.base.servico.domain.ServiceBuilder;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;

import java.util.Set;

public class EspecificarCatalogoController {

    /**
     * Repositório do Serviço
     */
    private final CatalogoRepositorio repoCat = PersistenceContext.repositories().catalogoRepositorio();


    /**
     * Especificação de um novo Catalogo
     */
    public Catalogo especificarCatalogo(String identificador, String titulo, String descBreve, String descCompleta,
                                       int icon, boolean atAprov, boolean atReal, Set<Keyword> keywords, String estado) {

        ServiceBuilder serviceBuilder = new ServiceBuilder();
        serviceBuilder.comIdentificador(identificador).comTitulo(titulo).comDescBreve(descBreve).comDescComp(descCompleta)
                .comIcon(icon).comAtAprov(atAprov)
                .comAtReal(atReal).comKeywords(keywords).comEstado(estado);

        return null;//this.repoCat.save(serviceBuilder.build());
    }

}

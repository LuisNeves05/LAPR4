package eapli.base.servico.application;

import eapli.base.catalogo.domain.Catalogo;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Keyword;
import eapli.base.servico.domain.ServiceBuilder;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;
import java.util.Set;

/**
 * Classe Controller da Especificação de um Serviço
 */
public class EspecificarServicoController {

    /**
     * Repositório do Serviço
     */
    private final ServicoRepositorio repoServ = PersistenceContext.repositories().servicoRepositorio();

    /**
     * Especificação de um novo Serviço
     */
    public Servico especificarServico(String identificador, String titulo, String descBreve, String descCompleta,
                                      int icon, boolean atAprov, boolean atReal, Set<Keyword> keywords, String estado, Catalogo catalogo) {

       ServiceBuilder serviceBuilder = new ServiceBuilder();
        serviceBuilder.comIdentificador(identificador).comTitulo(titulo).comDescBreve(descBreve).comDescComp(descCompleta)
                      .comIcon(icon).comAtAprov(atAprov)
                      .comAtReal(atReal).comKeywords(keywords).comEstado(estado);

       return this.repoServ.save(serviceBuilder.build());
    }

}

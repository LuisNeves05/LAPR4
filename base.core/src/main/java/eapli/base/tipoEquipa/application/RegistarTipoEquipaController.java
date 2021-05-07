package eapli.base.tipoEquipa.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Keyword;
import eapli.base.servico.domain.ServiceBuilder;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;
import eapli.base.tipoEquipa.domain.TipoEquipa;
import eapli.base.tipoEquipa.persistencia.TipoEquipaRepositorio;

import java.util.Set;

public class RegistarTipoEquipaController {


    /**
     * Classe Controller da Especificação de um Serviço
     */

    public class EspecificarServicoController {

        private final TipoEquipaRepositorio repoServ = PersistenceContext.repositories().tipoEquipaRepositorio();
//todo modelar classe Tipoequipa e alterar   metodo para retornar TipoEquipa
        public TipoEquipa tipoEquipaServico(String titulo, String descBreve, String descCompleta, int icon, boolean atAprov, boolean atReal, Set<Keyword> keywords, String estado) {

            ServiceBuilder serviceBuilder = new ServiceBuilder();
            serviceBuilder.comTitulo(titulo).comDescBreve(descBreve).comDescComp(descCompleta)
                    .comIcon(icon).comAtAprov(atAprov)
                    .comAtReal(atReal).comKeywords(keywords).comEstado(estado);

            return null ;//this.repoServ.save(serviceBuilder.build());
        }

    }
}

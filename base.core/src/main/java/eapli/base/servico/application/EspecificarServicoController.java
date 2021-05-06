package eapli.base.servico.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;

/**
 * Classe Controller da Especificação de um Serviço
 */

public class EspecificarServicoController {

    private final ServicoRepositorio repoServ = PersistenceContext.repositories().servicoRepositorio();



    public Servico especificarServico(String titulo, String descBreve, String descCompleta, int icon, String atAprov, String atReal, String estado) {
       Servico servico = new Servico(titulo, descBreve, descCompleta, icon, atAprov, atReal, estado);

       this.repoServ.save(servico);

       return null;
    }

}

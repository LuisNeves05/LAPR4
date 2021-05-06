package eapli.base.clientusermanagement.application;

import eapli.base.clientusermanagement.domain.servico.Keyword;
import eapli.base.clientusermanagement.domain.servico.Servico;

import java.util.Set;

/**
 * Classe Controller da Especificação de um Serviço
 */

public class EspecificarServicoController {

   public Servico especificarServico(String titulo, String descBreve, String descCompleta, int icon, Set<Keyword> keywords, String atAprov, String atReal, String estado) {
        Servico servico = new Servico(titulo, descBreve, descCompleta, icon, atAprov, atReal, estado, keywords);

        //RepositorioServico repoServ = new ServicoRepositorioJPAImpl();
        return null;//repoServ.add(servico);
    }
}

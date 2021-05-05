package eapli.base.especificarservico.application;

import eapli.base.especificarservico.domain.Keyword;
import eapli.base.especificarservico.domain.Servico;
import eapli.base.especificarservico.repositories.RepositorioServico;
import eapli.base.especificarservico.repositories.ServicoRepositorioJPAImpl;
import java.util.Set;

/**
 * Classe Controller da Especificação de um Serviço
 */

public class EspecificarServicoController {

   public Servico especificarServico(String titulo, String descBreve, String descCompleta, int icon, Set<Keyword> keywords, String atAprov, String atReal, String estado) {
        Servico servico = new Servico(titulo, descBreve, descCompleta, icon, atAprov, atReal, estado, keywords);

        RepositorioServico repoServ = new ServicoRepositorioJPAImpl();
        return repoServ.add(servico);
    }
}

package eapli.base.clientusermanagement.application;

import eapli.base.clientusermanagement.domain.Keyword;
import eapli.base.clientusermanagement.domain.Servico;
import eapli.base.clientusermanagement.repositories.RepositorioServico;
import eapli.base.clientusermanagement.repositories.ServicoRepositorioJPAImpl;

import java.util.List;

public class EspecificarServicoController {

   public Servico especificarServico(String titulo, String descBreve, String descCompleta, int icon, List<Keyword> keywords) {
        Servico servico = new Servico(titulo, descBreve, descCompleta, icon);
        for(Keyword k : keywords){

        }
        RepositorioServico repo = new ServicoRepositorioJPAImpl();
        return repo.add(servico);
    }

}

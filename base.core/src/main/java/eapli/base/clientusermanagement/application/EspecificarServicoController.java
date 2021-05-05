package eapli.base.clientusermanagement.application;

import eapli.base.clientusermanagement.domain.Atributo;
import eapli.base.clientusermanagement.domain.Formulario;
import eapli.base.clientusermanagement.domain.Keyword;
import eapli.base.clientusermanagement.domain.Servico;
import eapli.base.clientusermanagement.repositories.FormularioRepositorioJPAImpl;
import eapli.base.clientusermanagement.repositories.RepositorioFormulario;
import eapli.base.clientusermanagement.repositories.RepositorioServico;
import eapli.base.clientusermanagement.repositories.ServicoRepositorioJPAImpl;

import java.util.List;

public class EspecificarServicoController {

   public Servico especificarServico(String titulo, String descBreve, String descCompleta, int icon, List<Keyword> keywords, String atAprov, String atReal, String estado) {
        Servico servico = new Servico(titulo, descBreve, descCompleta, icon, atAprov, atReal, estado);

        for(Keyword k : keywords){

        }
        RepositorioServico repoServ = new ServicoRepositorioJPAImpl();
        return repoServ.add(servico);
    }

    public Formulario especificarFormulario(String nome, Servico servico){
        Formulario form = new Formulario(nome, servico);
        RepositorioFormulario repoForm = new FormularioRepositorioJPAImpl();

        return repoForm.add(form);
    }

    public Atributo especificarAtributos(String nomeVar, String label, String descAjuda, String tipoDadBase, String expRegular){
        //TODO
        return null;
    }

}

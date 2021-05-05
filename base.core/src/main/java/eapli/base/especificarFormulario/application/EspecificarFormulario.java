package eapli.base.especificarFormulario.application;

import eapli.base.clientusermanagement.domain.TipoDados;
import eapli.base.especificarFormulario.domain.Formulario;
import eapli.base.especificarFormulario.repositories.FormularioRepositorioJPAImpl;
import eapli.base.especificarFormulario.repositories.RepositorioFormulario;
import eapli.base.especificarservico.domain.Atributo;
import eapli.base.especificarservico.domain.Servico;

import java.util.Set;

/**
 * Classe Controller da Especificação de um Formulário
 */
public class EspecificarFormulario {

    /**
     * Especificação de um novo Formulario
     */
    public Formulario especificarFormulario(String nome, Servico servico, Set<Atributo> conjAtrib){
        Formulario form = new Formulario(nome, servico, conjAtrib);

        RepositorioFormulario repoForm = new FormularioRepositorioJPAImpl();

        return repoForm.add(form);
    }

}

package eapli.base.clientusermanagement.application;

import eapli.base.clientusermanagement.domain.formulario.Formulario;
import eapli.base.clientusermanagement.domain.formulario.Atributo;
import eapli.base.clientusermanagement.domain.servico.Servico;

import java.util.Set;

/**
 * Classe Controller da Especificação de um Formulário
 */
public class EspecificarFormularioController {

    /**
     * Especificação de um novo Formulario
     */
    public Formulario especificarFormulario(String nome, Servico servico, Set<Atributo> conjAtrib){
        Formulario form = new Formulario(nome, servico, conjAtrib);

        //RepositorioFormulario repoForm = new FormularioRepositorioJPAImpl();

        return null;//repoForm.add(form);
    }

}

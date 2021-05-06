package eapli.base.formulario.application;

import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.Atributo;
import eapli.base.servico.domain.Servico;

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

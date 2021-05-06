package eapli.base.formulario.application;

import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.FormularioBuilder;
import eapli.base.formulario.persistence.FormularioRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import eapli.base.servico.persistencia.ServicoRepositorio;

import java.util.Set;

/**
 * Classe Controller da Especificação de um Formulário
 */
public class EspecificarFormularioController {

    private final FormularioRepositorio repoForm = PersistenceContext.repositories().formularioRepositorio();

    /**
     * Especificação de um novo Formulario
     */
    public Formulario especificarFormulario(String nome, Servico servico, Set<Atributo> conjAtrib){

        FormularioBuilder formularioBuilder = new FormularioBuilder();
        formularioBuilder.comNome(nome).comServico(servico).comConjAtributos(conjAtrib);

        return repoForm.save(formularioBuilder.build());
    }

}

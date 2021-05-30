package eapli.base.formulario.application;

import eapli.base.formulario.builder.FormularioBuilder;
import eapli.base.formulario.domain.*;
import eapli.base.formulario.persistencia.FormularioRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;

/**
 * Classe Controller da Especificação de um Formulário
 */
public class EspecificarFormularioController {

    private final FormularioRepositorio repoForm = PersistenceContext.repositories().formularioRepositorio();

    /**
     * Especificação de um novo Formulario
     */
    public Formulario especificarFormulario(NomeFormulario nome){

        FormularioBuilder formularioBuilder = new FormularioBuilder();
        formularioBuilder.comNome(nome);

        return repoForm.save(formularioBuilder.build());
    }

    public void saveForm(Formulario f){
        repoForm.save(f);
    }

}

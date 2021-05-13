package eapli.base.formulario.application;

import eapli.base.formulario.domain.*;
import eapli.base.formulario.persistence.FormularioRepositorio;
import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.servico.domain.Servico;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe Controller da Especificação de um Formulário
 */
public class EspecificarFormularioController {

    private final FormularioRepositorio repoForm = PersistenceContext.repositories().formularioRepositorio();

    private final Set<Atributo> conjAtrib = new HashSet<>();

    /**
     * Especificação de um novo Formulario
     */
    public Formulario especificarFormulario(NomeFormulario nome, Servico servico){

        FormularioBuilder formularioBuilder = new FormularioBuilder();
        formularioBuilder.comNome(nome).comServico(servico).comConjAtributos(this.conjAtrib);

        return repoForm.save(formularioBuilder.build());
    }

    public boolean addAtributo(String nomeVar, String label, String descAjuda, String tpdad, String expRegular){
        Atributo atributo = new Atributo(nomeVar, label, descAjuda, new TipoDados(tpdad), expRegular);
        return this.conjAtrib.add(atributo);
    }
}

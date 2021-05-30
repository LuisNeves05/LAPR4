package eapli.base.formulario.builder;

import eapli.base.formulario.domain.Atributo;
import eapli.base.formulario.domain.Formulario;
import eapli.base.formulario.domain.NomeFormulario;
import eapli.framework.domain.model.DomainFactory;
import java.util.HashSet;
import java.util.Set;

public class FormularioBuilder implements DomainFactory<Formulario> {
    /**
     * Nome do formulário
     */
    private NomeFormulario nome;

    /**
     * Nome do formulário
     */
    private Set<Atributo> conjAtrib = new HashSet<>();

    public FormularioBuilder(){}

    public FormularioBuilder comNome(final NomeFormulario nome) {
        this.nome = nome;
        return this;
    }

    public FormularioBuilder comConjAtributos(final Set<Atributo> conjAtrib) {
        this.conjAtrib = conjAtrib;
        return this;
    }

    @Override
    public Formulario build() {
        // since the factory knows that all the parts are needed it could throw
        // an exception. however, we will leave that to the constructor

        return new Formulario(nome, conjAtrib);
    }
}

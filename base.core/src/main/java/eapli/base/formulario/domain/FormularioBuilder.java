package eapli.base.formulario.domain;

import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.DomainFactory;
import java.util.HashSet;
import java.util.Set;

public class FormularioBuilder implements DomainFactory<Formulario> {
    /**
     * Nome do formulário
     */
    private String nome;
    /**
     * Formulário de um respetivo serviço
     */
    private Servico servico;
    /**
     * Nome do formulário
     */
    private Set<Atributo> conjAtrib = new HashSet<>();

    public FormularioBuilder(){}

    public FormularioBuilder comNome(final String nome) {
        this.nome = nome;
        return this;
    }

    public FormularioBuilder comServico(final Servico servico) {
        this.servico = servico;
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

        return new Formulario(nome, servico, conjAtrib);
    }
}

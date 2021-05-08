package eapli.base.formulario.domain;

import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe da Entidade Formulario
 */
@Entity
@Table
public class    Formulario implements Comparable<Formulario>, AggregateRoot<Formulario> {

    /**
     * Identificador único do formulário
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nome do formulário
     */
    private NomeFormulario nome;
    /**
     * Formulário de um respetivo serviço
     */
    @ManyToOne
    private Servico servico;
    /**
     * Nome do formulário
     */
    @ElementCollection
    private Set<Atributo> conjuntoAtributos = new HashSet<>();

    /**
     * Construtor da entidade Formulário
     * @param nome Nome do Formulário
     * @param servico Formulário de um respetivo serviço
     * @param conjAtrib Conjunto de atributos associados ao Formulário
     */
    public Formulario(NomeFormulario nome, Servico servico, Set<Atributo> conjAtrib){
        this.nome = nome;
        this.servico = servico;
        this.conjuntoAtributos = conjAtrib;
    }

    /**
     * Construtor vazio requerido da entidade Formulario
     */
    public Formulario(){}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(Formulario other) {
        return 0;
    }

    @Override
    public Formulario identity() {
        return null;
    }

    @Override
    public boolean hasIdentity(Formulario otherId) {
        return false;
    }
}

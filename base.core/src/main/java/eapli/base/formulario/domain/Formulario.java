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
public class Formulario implements Comparable<Formulario>, AggregateRoot<Formulario> {

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
     * Nome do formulário
     */
    @ElementCollection
    private Set<Atributo> conjuntoAtributos = new HashSet<>();

    /**
     * Construtor da entidade Formulário
     * @param nome Nome do Formulário
     * @param conjAtrib Conjunto de atributos associados ao Formulário
     */
    public Formulario(NomeFormulario nome, Set<Atributo> conjAtrib){
        this.nome = nome;
        this.conjuntoAtributos = conjAtrib;
    }

    /**
     * Construtor vazio requerido da entidade Formulario
     */
    public Formulario(){}

    public boolean addAtributo(String nomeVar, String label, String descAjuda, String tpdad, String expRegular){
        Atributo atributo = new Atributo(nomeVar, label, descAjuda, new TipoDados(tpdad), expRegular);
        return this.conjuntoAtributos.add(atributo);
    }

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

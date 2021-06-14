package eapli.base.formulario.domain;

import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;
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
    @Embedded
    private NomeFormulario nome;

    /**
     * Nome do formulário
     */
    @ElementCollection
    private Set<Atributo> conjuntoAtributos = new HashSet<>();

    /**
     * Construtor da entidade Formulário
     * @param nome Nome do Formulário
     */
    public Formulario(NomeFormulario nome){
        this.nome = nome;
        conjuntoAtributos = new HashSet<>();
    }

    /**
     * Construtor vazio requerido da entidade Formulario
     */
    public Formulario(){}

    public boolean addAtributo(String nomeVar, String label, String descAjuda, TipoDados a , String expRegular){
        Atributo atributo = new Atributo(nomeVar, label, descAjuda, a , expRegular);
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
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean hasIdentity(Formulario otherId) {
        return false;
    }

    public Set<Atributo> atributos(){
        return this.conjuntoAtributos;
    }

    public NomeFormulario name(){
        return nome;
    }
}

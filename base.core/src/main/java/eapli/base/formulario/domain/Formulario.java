package eapli.base.formulario.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.*;

/**
 * Classe da Entidade Formulario
 */
@Entity
@Table
public class Formulario implements Comparable<Long>, AggregateRoot<Long> {

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
    private Map<Atributo, Integer> conjuntoAtributos;

    /**
     * Conjunto de scripts de validação do formulario
     */
    private String scriptValidacao;

    /**
     * Construtor da entidade Formulário
     * @param nome Nome do Formulário
     */
    public Formulario(NomeFormulario nome){
        this.nome = nome;
        conjuntoAtributos = new LinkedHashMap<>();
    }

    /**
     * Construtor vazio requerido da entidade Formulario
     */
    public Formulario(){}

    public void addAtributo(String nomeVar, String label, String descAjuda, TipoDados a , String expRegular){
        Atributo atributo = new Atributo(nomeVar, label, descAjuda, a , expRegular);
        this.conjuntoAtributos.put(atributo, conjuntoAtributos.size()+1);
    }

    public void addScript(String scriptValidacao){
        this.scriptValidacao = scriptValidacao;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(Long other) {
        return 0;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean hasIdentity(Long otherId) {
        return false;
    }

    public Map<Atributo, Integer> atributos(){
        return this.conjuntoAtributos;
    }

    public NomeFormulario name(){
        return nome;
    }

    public String scriptsValidacao(){
        return this.scriptValidacao;
    }

    @Override
    public String toString() {
        return "Formulario{" +
                "id=" + id +
                ", nome=" + nome +
                ", conjuntoAtributos=" + conjuntoAtributos +
                ", scriptValidacao='" + scriptValidacao + '\'' +
                '}';
    }
}
package eapli.base.formulario.domain;

import eapli.base.formulario.gramatica.*;
import eapli.base.formulario.gramatica.GramaticaLexer;
import eapli.base.formulario.gramatica.GramaticaParser;
import eapli.base.formularioPreenchido.domain.Resposta;
import eapli.framework.domain.model.AggregateRoot;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import javax.persistence.*;
import java.util.*;

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

    public Map<Atributo, Integer> atributos(){
        return this.conjuntoAtributos;
    }

    public NomeFormulario name(){
        return nome;
    }

    public String scriptsValidacao(){
        return this.scriptValidacao;
    }
}
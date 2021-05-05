package eapli.base.especificarFormulario.domain;

import eapli.base.especificarservico.domain.Atributo;
import eapli.base.especificarservico.domain.Servico;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe da Entidade Formulario
 */
@Entity
@Table
public class Formulario {

    /**
     * Identificador único do formulário
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nome do formulário
     */
    private String nome;
    /**
     * Formulário de um respetivo serviço
     */
    @ManyToOne
    private Servico servico;
    /**
     * Nome do formulário
     */
    @ElementCollection
    private Set<Atributo> conjAtrib = new HashSet<>();

    /**
     * Construtor da entidade Formulário
     * @param nome Nome do Formulário
     * @param servico Formulário de um respetivo serviço
     * @param conjAtrib Conjunto de atributos associados ao Formulário
     */
    public Formulario(String nome, Servico servico, Set<Atributo> conjAtrib){
        this.nome = nome;
        this.servico = servico;
        this.conjAtrib = conjAtrib;
    }

    /**
     * Construtor vazio requerido da entidade Formulario
     */
    public Formulario(){}

}

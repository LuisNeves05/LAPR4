package eapli.base.clientusermanagement.domain;

import javax.persistence.*;

@Entity
@Table
public class Formulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Atributo atributo;

    @ManyToOne
    private Servico servico;

    public Formulario(String nome, Atributo atributo, Servico servico){
        this.atributo = atributo;
        this.nome = nome;
        this.servico = servico;
    }

    public Formulario(){}

}

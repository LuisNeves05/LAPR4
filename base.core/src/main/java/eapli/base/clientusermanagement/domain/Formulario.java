package eapli.base.clientusermanagement.domain;

import javax.persistence.*;

@Entity
@Table
public class Formulario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Servico servico;

    public Formulario(String nome, Servico servico){
        this.nome = nome;
        this.servico = servico;
    }

    public Formulario(){}

}

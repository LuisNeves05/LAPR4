package eapli.base.tarefa.domain;

import eapli.base.colaborador.domain.Colaborador;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TarefaAprovacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<Colaborador> colabsAprova;

}
package eapli.base.fluxo.domain;

import eapli.base.tarefa.domain.Tarefa;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AtividadeRealizacao extends FluxoAtividade implements AggregateRoot<Long>, Comparable<Long>  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<Tarefa> tarefasReal;

    protected AtividadeRealizacao(){}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }
}

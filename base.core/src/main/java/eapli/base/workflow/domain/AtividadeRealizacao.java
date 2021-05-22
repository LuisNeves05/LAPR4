package eapli.base.workflow.domain;

import eapli.base.tarefa.domain.Tarefa;
import eapli.framework.domain.model.AggregateRoot;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class AtividadeRealizacao extends FluxoAtividade implements AggregateRoot<Long>, Comparable<Long>{

    @Id
    private Long id;

    @OneToMany
    private Set<Tarefa> tarefas;

    protected AtividadeRealizacao(){}

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
        return null;
    }

    @Override
    public boolean hasIdentity(Long otherId) {
        return false;
    }
}

package eapli.base.fluxo.domain;

import eapli.base.tarefa.domain.TarefaExecucao;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AtividadeRealizacao extends FluxoAtividade implements AggregateRoot<Long>, Comparable<Long>  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<TarefaExecucao> tarefasExecucao;

    protected AtividadeRealizacao(){}

    public AtividadeRealizacao(Set<TarefaExecucao> tarefasExecucao){
        this.tarefasExecucao = tarefasExecucao;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }
}

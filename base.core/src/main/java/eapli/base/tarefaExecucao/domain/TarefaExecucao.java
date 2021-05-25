package eapli.base.tarefaExecucao.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TarefaExecucao implements AggregateRoot<TarefaExecucao>, Comparable<TarefaExecucao> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}

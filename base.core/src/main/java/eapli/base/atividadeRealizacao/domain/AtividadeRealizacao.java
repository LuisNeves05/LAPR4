package eapli.base.atividadeRealizacao.domain;

import eapli.base.tarefaExecucao.domain.TarefaExecucao;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AtividadeRealizacao implements AggregateRoot<Long>, Comparable<Long>  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<TarefaExecucao> tarefasExecucao;

    public AtividadeRealizacao(){
        this.tarefasExecucao = new HashSet<>();
    }

    public void adicionarTarefaExecucao(TarefaExecucao tarExec){
        tarefasExecucao.add(tarExec);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.id;
    }
}

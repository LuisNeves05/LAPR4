package eapli.base.tarefaExecucao.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TarefaAutomatica extends TarefaExecucao implements Comparable<TarefaExecucao>{

    //TODO VER COMO FAZER ISTO OU COMO FUNCIONA OU LA O QUE ISTO É

    public TarefaAutomatica(){}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public TarefaExecucao identity() {
        return null;
    }
}

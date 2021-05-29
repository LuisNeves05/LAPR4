package eapli.base.tarefaAutomatica.domain;

import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class TarefaAutomatica implements Comparable<Long>, AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Ticket ticket;

    public TarefaAutomatica(Ticket ticket){
        this.ticket = ticket;
    }

    protected TarefaAutomatica(){}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return id;
    }
}

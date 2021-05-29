package eapli.base.tarefaManual.domain;

import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class TarefaManual implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Ticket ticket;

    protected TarefaManual(){}

    protected TarefaManual(Ticket ticket){
        this.ticket = ticket;
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public String toString() {
        return ticket.toString();
    }
}
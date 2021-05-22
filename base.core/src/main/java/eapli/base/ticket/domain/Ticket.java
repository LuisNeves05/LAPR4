package eapli.base.ticket.domain;

import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
@Table
public class Ticket implements AggregateRoot<Long>, Comparable<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Ticket(){}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }
}

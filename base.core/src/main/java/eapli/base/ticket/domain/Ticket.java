package eapli.base.ticket.domain;

import javax.persistence.*;

@Entity
@Table
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Ticket(){}

}

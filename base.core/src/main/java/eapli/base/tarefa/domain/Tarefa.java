package eapli.base.tarefa.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.servico.domain.Servico;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class Tarefa implements AggregateRoot<Tarefa>, Comparable<Tarefa> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Colaborador colabTarefa;

    @OneToOne
    private Servico servico;

    @OneToOne
    private Ticket ticket;

    @Override
    public boolean sameAs(Object other) {
        return false;
    }
    @Override
    public Tarefa identity() {
        return null;
    }
}

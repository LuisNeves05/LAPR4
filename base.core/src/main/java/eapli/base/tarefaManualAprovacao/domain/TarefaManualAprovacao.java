package eapli.base.tarefaManualAprovacao.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TarefaManualAprovacao implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Ticket ticket;

    @ManyToMany
    private Set<Colaborador> colabsAprova = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private EstadoAprovacao estadoAprovacao;

    public TarefaManualAprovacao(Ticket ticket){
        this.ticket = ticket;
        this.estadoAprovacao = EstadoAprovacao.POR_APROVAR;
    }

    protected TarefaManualAprovacao(){}

    public void assignaColabAprovacao(Colaborador colaborador){
        colabsAprova.add(colaborador);
    }

    public Ticket procurarTicket(){
        return ticket;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return id;
    }

    public EstadoAprovacao estadoAprov() {
        return estadoAprovacao;
    }
}

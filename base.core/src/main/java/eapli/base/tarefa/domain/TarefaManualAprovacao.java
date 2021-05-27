package eapli.base.tarefa.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.tarefa.domain.estado.EstadoAprovacao;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TarefaManualAprovacao extends TarefaManual implements AggregateRoot<Long>, Comparable<Long> {

    @OneToMany
    private Set<Colaborador> colabsAprova;

    private EstadoAprovacao estadoAprovacao;

    public TarefaManualAprovacao(Ticket ticket){
        super(ticket);
    }

    protected TarefaManualAprovacao() {}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return super.identity();
    }
}

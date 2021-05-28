package eapli.base.tarefa.domain;

import eapli.base.atividadeAprovacao.domain.ColaboradoresAprovacao;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.tarefa.domain.estado.EstadoAprovacao;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TarefaManualAprovacao extends TarefaManual implements AggregateRoot<Long>, Comparable<Long> {

    @OneToMany
    private Set<Colaborador> colabsAprova = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private EstadoAprovacao estadoAprovacao;

    public TarefaManualAprovacao(Ticket ticket){
        super(ticket);
        this.estadoAprovacao = EstadoAprovacao.POR_APROVAR;
    }

    protected TarefaManualAprovacao() {}

    public void assignaColabAprovacao(Colaborador colaborador){
        colabsAprova.add(colaborador);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return super.identity();
    }
}

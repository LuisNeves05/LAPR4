package eapli.base.tarefa.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefa.domain.estado.EstadoRealizacao;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TarefaManualExecucao extends TarefaManual implements AggregateRoot<Long>, Comparable<Long> {

    @OneToOne
    private Colaborador colabExecuta;

    @OneToMany
    private Set<Equipa> equipasExecuta;

    @Column(name = "ESTADO_REALIZACAO")
    private EstadoRealizacao estadoRealizacao;

    public TarefaManualExecucao(Ticket ticket, Set<Equipa> equipasExecuta){
        super(ticket);
        this.equipasExecuta = equipasExecuta;
    }

    public TarefaManualExecucao(Ticket ticket, Colaborador colabExecuta){
        super(ticket);
        this.colabExecuta = colabExecuta;
    }

    protected TarefaManualExecucao() {}

    public void adicionaEquipaExecucao(Equipa equipaExec){
        equipasExecuta.add(equipaExec);
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

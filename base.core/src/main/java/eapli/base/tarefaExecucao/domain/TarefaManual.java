package eapli.base.tarefaExecucao.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.ticket.domain.Ticket;
import eapli.base.tipoTarefa.domain.TipoTarefa;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TarefaManual extends TarefaExecucao implements AggregateRoot<TarefaExecucao>, Comparable<TarefaExecucao> {

    @OneToOne
    private Colaborador colabExecuta;

    @OneToMany
    private Set<Equipa> equipasExecuta;

    @OneToOne
    private TipoTarefa tipoTarefa;

    @OneToOne
    private Ticket ticket;

    public TarefaManual(){}

    public TarefaManual(TipoTarefa tpTarefa, Ticket ticket){
        equipasExecuta = new HashSet<>();
        this.tipoTarefa = tpTarefa;
        this.ticket = ticket;
    }

    public TarefaManual(Colaborador colabExec, TipoTarefa tpTarefa, Ticket ticket){
        this.colabExecuta = colabExec;
        this.tipoTarefa = tpTarefa;
        this.ticket = ticket;
    }

    public void adicionaEquipaExecucao(Equipa equipaExec){
        equipasExecuta.add(equipaExec);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public TarefaManual identity() {
        return null;
    }
}
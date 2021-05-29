package eapli.base.tarefaManual.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefaManual.domain.estado.EstadoRealizacao;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TarefaManualExecucao extends TarefaManual implements AggregateRoot<Long>, Comparable<Long> {

    @OneToOne
    private Colaborador colabExecuta;

    @ManyToMany
    private Set<Equipa> equipasExecuta;

    @Column(name = "ESTADO_REALIZACAO")
    @Enumerated(EnumType.STRING)
    private EstadoRealizacao estadoRealizacao;

    public TarefaManualExecucao(Ticket ticket, Set<Equipa> equipasExecuta){
        super(ticket);
        this.equipasExecuta = equipasExecuta;
        this.estadoRealizacao = EstadoRealizacao.POR_EXECUTAR;
    }

    public TarefaManualExecucao(Ticket ticket, Colaborador colabExecuta, EstadoRealizacao estadoRealizacao){
        super(ticket);
        this.colabExecuta = colabExecuta;
        this.estadoRealizacao = estadoRealizacao;
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


    public void retirarEquipa(){
         this.equipasExecuta.clear();
    }
    public void defineColaboradorExecutante(Colaborador colaborador){
        this.colabExecuta= colaborador;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package eapli.base.tarefaManualExecucao.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefaManualExecucao.dto.TarefaManualExecucaoDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Set;

@Entity
public class TarefaManualExecucao implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Ticket ticket;

    @OneToOne
    private Colaborador colabExecuta;

    @ManyToMany
    private Set<Equipa> equipasExecuta;

    @Column(name = "ESTADO_REALIZACAO")
    @Enumerated(EnumType.STRING)
    private EstadoRealizacao estadoRealizacao;

    public EstadoRealizacao estadoRealizacao() {
        return estadoRealizacao;
    }

    public TarefaManualExecucao(Ticket ticket, Set<Equipa> equipasExecuta){
        this.ticket = ticket;
        this.equipasExecuta = equipasExecuta;
        this.estadoRealizacao = EstadoRealizacao.POR_EXECUTAR;
    }

    public TarefaManualExecucao(Ticket ticket, Colaborador colabExecuta, EstadoRealizacao estadoRealizacao){
        this.ticket = ticket;
        this.colabExecuta = colabExecuta;
        this.estadoRealizacao = estadoRealizacao;
    }

    protected TarefaManualExecucao() {}

    public void adicionaEquipaExecucao(Equipa equipaExec){
        equipasExecuta.add(equipaExec);
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


    public TarefaManualExecucaoDTO toDTO(){
        return new TarefaManualExecucaoDTO(id, this.estadoRealizacao, this.colabExecuta, "");
    }
}

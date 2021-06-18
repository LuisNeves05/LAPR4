package eapli.base.tarefaManualExecucao.domain;

import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.equipa.domain.Equipa;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.tarefaManualExecucao.dto.TarefaManualExecucaoDTO;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.time.util.Calendars;

import javax.persistence.*;
import java.util.Calendar;
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

    @OneToOne
    private AtividadeRealizacao atividadeRealizacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataRealizacao;


    public TarefaManualExecucao(Ticket ticket, Set<Equipa> equipasExecuta, AtividadeRealizacao atividadeRealizacao){
        this.ticket = ticket;
        this.equipasExecuta = equipasExecuta;
        this.estadoRealizacao = EstadoRealizacao.POR_EXECUTAR;
        this.atividadeRealizacao = atividadeRealizacao;
    }

    public TarefaManualExecucao(Ticket ticket, Colaborador colabExecuta, EstadoRealizacao estadoRealizacao, AtividadeRealizacao atividadeRealizacao){
        this.ticket = ticket;
        this.colabExecuta = colabExecuta;
        this.estadoRealizacao = estadoRealizacao;
        this.atividadeRealizacao = atividadeRealizacao;
    }

    protected TarefaManualExecucao() {}

    public EstadoRealizacao estadoRealizacao() {
        return estadoRealizacao;
    }

    public Set<Equipa> equipasQueExecutam() {
        return equipasExecuta;
    }

    public Ticket ticketDaTarefa(){
        return ticket;
    }

    public void adicionaEquipaExecucao(Equipa equipaExec){
        equipasExecuta.add(equipaExec);
    }

    public void retirarEquipa(){
        this.equipasExecuta.clear();
    }

    public void defineColaboradorExecutante(Colaborador colaborador){
        this.colabExecuta= colaborador;
    }

    public Calendar dataDecisaoRealizacao(){
        return dataRealizacao;
    }

    public void definirMomentoRealizacao(){
        dataRealizacao = Calendars.now();
    }

    public AtividadeRealizacao atividadeRealizacaoDaTarefa(){
        return atividadeRealizacao;
    }

    public void  concluir(){
        estadoRealizacao = EstadoRealizacao.CONCLUIDA;
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TarefaManualExecucao)) {
            return false;
        }

        final TarefaManualExecucao that = (TarefaManualExecucao) other;
        return this.equals(that);
    }

    @Override
    public Long identity() {
        return id;
    }


    @Override
    public String toString() {
        return ticket.toString();
    }


    public TarefaManualExecucaoDTO toDTO(){
        return new TarefaManualExecucaoDTO(id, this.estadoRealizacao, this.colabExecuta, "");
    }

}

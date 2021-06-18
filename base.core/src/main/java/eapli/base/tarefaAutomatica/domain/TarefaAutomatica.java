package eapli.base.tarefaAutomatica.domain;

import eapli.base.atividadeRealizacao.domain.AtividadeRealizacao;
import eapli.base.tarefaManualAprovacao.domain.TarefaManualAprovacao;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;

@Entity
public class TarefaAutomatica implements Comparable<Long>, AggregateRoot<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Ticket ticket;

    @OneToOne
    private AtividadeRealizacao atividadeRealizacao;

    private String scriptExecucao;

    public TarefaAutomatica(Ticket ticket, String scriptExecucao, AtividadeRealizacao ar){
        this.ticket = ticket;
        this.scriptExecucao = scriptExecucao;
        this.atividadeRealizacao = ar;
    }

    protected TarefaAutomatica(){}

    public Ticket ticketDaTarefa(){
        return ticket;
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TarefaAutomatica)) {
            return false;
        }

        final TarefaAutomatica that = (TarefaAutomatica) other;
        return this.equals(that);
    }

    @Override
    public String toString() {
        return "TarefaAutomatica{" +
                "id=" + id +
                ", ticket=" + ticket +
                ", atividadeRealizacao=" + atividadeRealizacao +
                ", scriptExecucao='" + scriptExecucao + '\'' +
                '}';
    }

    @Override
    public Long identity() {
        return id;
    }
}

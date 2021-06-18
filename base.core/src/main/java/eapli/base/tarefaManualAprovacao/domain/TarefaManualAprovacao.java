package eapli.base.tarefaManualAprovacao.domain;

import eapli.base.atividadeAprovacao.domain.AtividadeAprovacao;
import eapli.base.colaborador.domain.Colaborador;
import eapli.base.servico.domain.Servico;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.time.util.Calendars;
import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TarefaManualAprovacao implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Ticket ticket;

    @OneToOne
    private Colaborador colabAprov;

    @Enumerated(EnumType.STRING)
    private EstadoAprovacao estadoAprovacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataAprovado;

    @OneToOne
    private AtividadeAprovacao atividadeAprovacao;

    public TarefaManualAprovacao(Ticket ticket, AtividadeAprovacao atividadeAprovacao, Colaborador colabAprov){
        this.ticket = ticket;
        this.estadoAprovacao = EstadoAprovacao.POR_APROVAR;
        this.atividadeAprovacao = atividadeAprovacao;
        this.colabAprov = colabAprov;
    }

    protected TarefaManualAprovacao(){}

    public Ticket ticketDaTarefa(){
        return ticket;
    }

    public Calendar dataDecisaoAprovacao(){
        return dataAprovado;
    }

    public void definirMomentoAprovacao(){
        dataAprovado = Calendars.now();
    }

    public EstadoAprovacao estadoAprov() { return estadoAprovacao; }

    public AtividadeAprovacao atividadeAprovacaoDaTarefa(){
        return atividadeAprovacao;
    }

    public void aprovado(){
        this.estadoAprovacao = EstadoAprovacao.APROVADO;
    }
    public void rejeitado(){
        this.estadoAprovacao = EstadoAprovacao.REJEITADO;
    }

    @Override
    public boolean sameAs(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TarefaManualAprovacao)) {
            return false;
        }

        final TarefaManualAprovacao that = (TarefaManualAprovacao) other;
        return this.equals(that);
    }

    @Override
    public Long identity() {
        return id;
    }

    @Override
    public String toString() {
        return
                " - "+ "   "+
                  ticket +
                "   Estado de Aprovacao : " + this.estadoAprovacao.toString();

    }
}


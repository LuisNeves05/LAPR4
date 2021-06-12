package eapli.base.tarefaManualAprovacao.domain;

import eapli.base.Utils.DecisaoEnum;
import eapli.base.colaborador.domain.Colaborador;
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

    @ManyToMany
    private Set<Colaborador> colabsAprova = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private EstadoAprovacao estadoAprovacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataAprovado;

    public TarefaManualAprovacao(Ticket ticket){
        this.ticket = ticket;
        this.estadoAprovacao = EstadoAprovacao.POR_APROVAR;
    }

    @Enumerated(EnumType.STRING)
    private DecisaoEnum decisao;

    @Column(name = "COMENTARIO")
    private String comentario;

    protected TarefaManualAprovacao(){}

    public Ticket procurarTicket(){
        return ticket;
    }

    public void assignaColabAprovacao(Colaborador colaborador){
        colabsAprova.add(colaborador);
    }

    public Calendar dataDecisaoAprovacao(){
        return dataAprovado;
    }

    public void definirMomentoAprovacao(){
        dataAprovado = Calendars.now();
    }

    public EstadoAprovacao estadoAprov() {
        return estadoAprovacao;
    }

    public Ticket getTicket() {
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

    public DecisaoEnum obterDecisao() {
        return decisao;
    }

    public void decidirTarefa(DecisaoEnum decisao) {
        this.decisao = decisao;
    }

    public String obterComentario() {
        return comentario;
    }

    public void fazerComentario(String comentario) {
        this.comentario = comentario;
    }
}


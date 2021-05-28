package eapli.base.ticket.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.time.util.Calendars;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Ticket implements AggregateRoot<Long>, Comparable<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Colaborador colabRequisitou;

    @Temporal(TemporalType.DATE)
    private Calendar createdOn;

    @OneToOne
    private Servico servico;

    @OneToOne
    private NivelCriticidade nivelCriticidade;

    private String urgenciaTicket;

    @OneToMany
    private Set<FormularioPreenchido> formulariosPreenchidos;

    @Column(name = "ESTADO_TICKET")
    @Enumerated(EnumType.STRING)
    private EstadoTicket estadoTicket;

    protected Ticket(){}

    public Ticket(Colaborador colabRequisitou, Servico servico, NivelCriticidade nivelCriticidade, String urgenciaTicket, EstadoTicket estadoTicket) {
        this.colabRequisitou = colabRequisitou;
        this.createdOn = Calendars.now();
        this.servico = servico;
        this.nivelCriticidade = nivelCriticidade;
        this.urgenciaTicket = urgenciaTicket;
        this.formulariosPreenchidos = new HashSet<>();
        this.estadoTicket = estadoTicket;
    }

    public void adicionaFormularioResposta(FormularioPreenchido fp){
        formulariosPreenchidos.add(fp);
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }
}

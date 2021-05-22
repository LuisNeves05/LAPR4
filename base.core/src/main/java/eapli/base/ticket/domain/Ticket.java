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

@Entity
@Table
public class Ticket implements AggregateRoot<Long>, Comparable<Long>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Colaborador colab;

    @Temporal(TemporalType.DATE)
    private Calendar createdOn;

    @OneToOne
    private Servico servico;

    @OneToOne
    private NivelCriticidade nivelCriticidade;

    private String urgenciaTicket;

    @OneToOne
    private FormularioPreenchido formularioPreenchido;

    @Temporal(TemporalType.DATE)
    private Date dataLimResol;

    public Ticket(){
        this.createdOn = Calendars.now();
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

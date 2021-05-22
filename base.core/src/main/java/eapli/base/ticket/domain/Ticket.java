package eapli.base.ticket.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;

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
    private Colaborador colabRequisitou;

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

    @Column(name = "ESTADO_TICKET")
    @Enumerated(EnumType.STRING)
    private EstadoTicket estadoTicket;

    public Ticket(){}

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return null;
    }
}

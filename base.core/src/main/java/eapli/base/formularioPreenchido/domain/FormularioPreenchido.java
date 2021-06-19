package eapli.base.formularioPreenchido.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.formulario.domain.Formulario;
import eapli.base.ticket.domain.Ticket;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.time.util.Calendars;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
@Table
public class FormularioPreenchido implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Formulario formulario;

    @Temporal(TemporalType.DATE)
    private Calendar createdOn;

    @OneToOne
    private Colaborador colaboradorPedido;

    private String urgencia;

    @ElementCollection
    private Set<Resposta> respostas;

    public FormularioPreenchido(){}

    public FormularioPreenchido(Formulario formulario, String urgencia, Set<Resposta> respostaSet,  Colaborador colaborador){
        this.formulario = formulario;
        this.createdOn = Calendars.now();
        this.urgencia = urgencia;
        this.respostas = respostaSet;
        this.colaboradorPedido = colaborador;
    }

    public FormularioPreenchido(Formulario formulario, Set<Resposta> respostaSet,  Colaborador colaborador){
        this.formulario = formulario;
        this.createdOn = Calendars.now();
        this.respostas = respostaSet;
        this.colaboradorPedido = colaborador;
    }

    @Override
    public int compareTo(Long other) {
        return AggregateRoot.super.compareTo(other);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
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

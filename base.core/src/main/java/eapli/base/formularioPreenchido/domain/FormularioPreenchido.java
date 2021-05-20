package eapli.base.formularioPreenchido.domain;

import eapli.base.formulario.domain.Formulario;
import eapli.base.servico.domain.Servico;
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

    @OneToOne
    private Servico servico;

    @Temporal(TemporalType.DATE)
    private Calendar createdOn;

    private String urgencia;

    @ElementCollection
    private Set<Resposta> respostas;

    public FormularioPreenchido(){}

    public FormularioPreenchido(Formulario formulario, String urgencia, Set<Resposta> respostaSet, Servico servico){
        this.formulario = formulario;
        this.createdOn = Calendars.now();
        this.urgencia = urgencia;
        this.respostas = respostaSet;
        this.servico = servico;
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

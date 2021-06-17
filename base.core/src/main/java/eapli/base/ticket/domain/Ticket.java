package eapli.base.ticket.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.criticidade.domain.NivelCriticidade;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.time.util.Calendars;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Table
public class Ticket implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Colaborador colabRequisitou;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar createdOn;

    @OneToOne
    private Servico servico;

    private String urgenciaTicket;

    @OneToMany
    private Set<FormularioPreenchido> formulariosPreenchidos;

    @Column(name = "ESTADO_TICKET")
    @Enumerated(EnumType.STRING)
    private EstadoTicket estadoTicket;

    private int periodoMaxApr;

    private int periodoMaxRes;

    private String feedback;

    public Calendar criacaoTicket() {
        return createdOn;
    }

    protected Ticket() {
    }

    public Ticket(Colaborador colabRequisitou, Servico servico, String urgenciaTicket,
                  EstadoTicket estadoTicket) {
        this.colabRequisitou = colabRequisitou;
        this.createdOn = Calendars.now();
        this.servico = servico;
        this.urgenciaTicket = urgenciaTicket;
        this.formulariosPreenchidos = new HashSet<>();
        this.estadoTicket = estadoTicket;
        this.periodoMaxApr = servico.nivelCriticidadeServico().objetivos().aprovacaoMax();
        this.periodoMaxRes = servico.nivelCriticidadeServico().objetivos().resolucaoMax();
    }

    public void adicionaFormularioResposta(FormularioPreenchido fp) {
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


    @Override
    public String toString() {
        return "Ticket " + id + " : \n" +
                "       Colaborador Requisitante : " + colabRequisitou.nomeToString() +
                "       Criado em : " + createdOn.getTime().toString() +
                "       Serviço : " + servico.descricaoBreveDoServico() +
                "       Urgência : " + urgenciaTicket;
    }

    public Servico servicoDoTicket() {
        return servico;
    }

    public int periodoMaxApr() {
        return periodoMaxApr;
    }

    public int periodoMaxRes() {
        return periodoMaxRes;
    }

    public EstadoTicket estadoTicket() {
        return this.estadoTicket;
    }

    public void completarTicket() {
        this.estadoTicket = EstadoTicket.CONCLUIDO;
    }

    public void inacabadoTicket() {
        this.estadoTicket = EstadoTicket.INACABADO;
    }

    public void emExecucao() {
        this.estadoTicket = EstadoTicket.EM_EXECUCAO;
    }

    public void aprovarTicket() {
        this.estadoTicket = EstadoTicket.APROVADO;
    }

    public void rejeitarTicket() {
        this.estadoTicket = EstadoTicket.REJEITADO;
    }

    public void feedbackDoColaborador(String respostaFeedback) {
        this.feedback = respostaFeedback;
    }
}
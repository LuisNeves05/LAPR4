package eapli.base.ticket.domain;

import eapli.base.colaborador.domain.Colaborador;
import eapli.base.formularioPreenchido.domain.FormularioPreenchido;
import eapli.base.servico.domain.Servico;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.time.util.Calendars;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Ticket implements AggregateRoot<Long>, Comparable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Colaborador colabRequisitou;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataInicioTicket;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataFimExecucaoTicket;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataFimAprovacaoTicket;

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

    private int periodoMedioApr;

    private int periodoMedioRes;

    private String feedback;

    private String slaDecisao;

    public Calendar criacaoTicket() {
        return dataInicioTicket;
    }

    protected Ticket() {}

    public Ticket(Colaborador colabRequisitou, Servico servico, String urgenciaTicket,
                  EstadoTicket estadoTicket) {
        this.colabRequisitou = colabRequisitou;
        this.dataInicioTicket = Calendars.now();
        this.servico = servico;
        this.urgenciaTicket = urgenciaTicket;
        this.formulariosPreenchidos = new HashSet<>();
        this.estadoTicket = estadoTicket;
        this.periodoMaxApr = servico.nivelCriticidadeServico().objetivos().tempoMaximoAprovacao();
        this.periodoMaxRes = servico.nivelCriticidadeServico().objetivos().tempoMaximoResolucao();
        this.periodoMedioApr = servico.nivelCriticidadeServico().objetivos().tempoMedioAprovacao();
        this.periodoMedioRes = servico.nivelCriticidadeServico().objetivos().tempoMedioResolucao();
    }

    public void adicionaFormularioResposta(FormularioPreenchido fp) {
        formulariosPreenchidos.add(fp);
    }

    public Set<FormularioPreenchido> formulariosPreenchidosDoTicket() {
        return formulariosPreenchidos;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Long identity() {
        return this.id;
    }


    @Override
    public String toString() {
        return "Ticket " + id + " : \n" +
                "       Colaborador Requisitante : " + colabRequisitou.nomeToString() +
                "       Criado em : " + dataInicioTicket.getTime() +
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

    public Colaborador colabQueRequisita() {
        return colabRequisitou;
    }

    public EstadoTicket estadoTicket() {
        return this.estadoTicket;
    }

    public void completarTicket() {
        this.estadoTicket = EstadoTicket.CONCLUIDO;
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

    public Calendar datafinalizacaoTicket() { return this.dataFimExecucaoTicket; }

    public void definirFinalTicket() { this.dataFimExecucaoTicket = Calendars.now(); }

    public Calendar dataAprovacaoTicket() { return this.dataFimAprovacaoTicket; }

    public void definirFinalAprovacaoTicket() { this.dataFimAprovacaoTicket = Calendars.now(); }

    public void definirComentarioSLA(String comentario){this.slaDecisao= comentario;}
}
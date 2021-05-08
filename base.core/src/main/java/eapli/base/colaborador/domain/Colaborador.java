package eapli.base.colaborador.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class Colaborador implements Comparable<MecanographicNumber>, AggregateRoot<MecanographicNumber> {

    @Column(name = "NOME_CURTO")
    @Embedded
    private NomeCurto nomeCurto;

    @Column(name = "NOME_COMPLETO")
    @Embedded
    private NomeCompleto nomeCompleto;

    @EmbeddedId
    @Column(name = "NUM_MECANOGRAFICO")
    private MecanographicNumber numMecanografico;

    @Column(name = "LOCAL_RESIDENCIA") //nao obrigatoria
    @Embedded
    private Morada localResidencia;

    @Column(name = "CONTACTO")
    @Embedded
    private NrContacto nrContacto;

    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;

    @Column(name = "FUNCAO") //nao obrigatoria
    @ElementCollection
    private Set<Funcao> funcao;  //TODO CRIAR CLASSE FUNCAO @ONETOMANY

    @OneToOne
    private Colaborador colaboradorResponsavel;

    @OneToOne
    private SystemUser systemUser;

    public Colaborador(NomeCurto nomeCurto,NomeCompleto nomeCompleto, MecanographicNumber numMecanografico,
                       Morada localResidencia, NrContacto nrContacto, Date dataNascimento,
                       Set<Funcao> funcao, Colaborador colaboradorResponsavel){
        this.nomeCurto = nomeCurto;
        this.nomeCompleto = nomeCompleto;
        this.numMecanografico = numMecanografico;
        this.localResidencia = localResidencia;
        this.nrContacto = nrContacto;
        this.dataNascimento = dataNascimento;
        this.funcao = funcao;
        this.colaboradorResponsavel = colaboradorResponsavel;

    }

    protected Colaborador(){}


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(MecanographicNumber o){return this.numMecanografico.compareTo(o);}

    @Override
    public MecanographicNumber identity() {return null;}

    @Override
    public String toString() {
        return "Colaborador{" +
                "nomeCurto=" + nomeCurto +
                ", nomeCompleto=" + nomeCompleto +
                ", numMecanografico=" + numMecanografico +
                ", localResidencia=" + localResidencia +
                ", nrContacto=" + nrContacto +
                ", dataNascimento=" + dataNascimento +
                ", funcao=" + funcao +
                ", colaboradorResponsavel=" + colaboradorResponsavel +
                ", systemUser=" + systemUser +
                '}';
    }
}
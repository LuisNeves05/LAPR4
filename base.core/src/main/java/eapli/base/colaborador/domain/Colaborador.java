package eapli.base.colaborador.domain;

import eapli.base.clientusermanagement.domain.MecanographicNumber;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Colaborador implements Comparable<Colaborador>, AggregateRoot<Colaborador> {

    private String nomeCurto;

    private String nomeCompleto;

    @Id
    private MecanographicNumber numMecanografico;

    private String localResidencia;

    private String email;

    private int nrContacto;

    private Date dataNascimento;

    private String password;

    private String funcao;

    @OneToOne
    private Colaborador colaboradorResponsavel;

    public Colaborador(String nomeCurto,String nomeCompleto, MecanographicNumber numMecanografico, String localResidencia, String email, int nrContacto,
                       Date dataNascimento, String password, String funcao, Colaborador colaboradorResponsavel){
        this.nomeCurto = nomeCurto;
        this.nomeCompleto = nomeCompleto;
        this.numMecanografico = numMecanografico;
        this.localResidencia = localResidencia;
        this.email = email;
        this.nrContacto = nrContacto;
        this.dataNascimento = dataNascimento;
        this.password = password;
        this.funcao = funcao;
        this.colaboradorResponsavel = colaboradorResponsavel;

    }

    protected Colaborador(){}


    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public int compareTo(Colaborador o){return 0;}

    @Override
    public Colaborador identity() {return null;}

    @Override
    public boolean hasIdentity(Colaborador otherNumMecanografico){return false;}

}